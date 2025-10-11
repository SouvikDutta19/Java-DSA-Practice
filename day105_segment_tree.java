// Segment Tree implementation for Range Sum Queries and Updates
public class day105_segment_tree {
    static int[] tree, arr;

    public static void buildTree(int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
            return;
        }
        int mid = (start + end) / 2;
        buildTree(2 * node, start, mid);
        buildTree(2 * node + 1, mid + 1, end);
        tree[node] = tree[2 * node] + tree[2 * node + 1];
    }

    public static void update(int node, int start, int end, int idx, int val) {
        if (start == end) {
            arr[idx] = val;
            tree[node] = val;
            return;
        }
        int mid = (start + end) / 2;
        if (idx <= mid)
            update(2 * node, start, mid, idx, val);
        else
            update(2 * node + 1, mid + 1, end, idx, val);
        tree[node] = tree[2 * node] + tree[2 * node + 1];
    }

    public static int query(int node, int start, int end, int L, int R) {
        if (R < start || end < L)
            return 0;
        if (L <= start && end <= R)
            return tree[node];
        int mid = (start + end) / 2;
        int leftSum = query(2 * node, start, mid, L, R);
        int rightSum = query(2 * node + 1, mid + 1, end, L, R);
        return leftSum + rightSum;
    }

    public static void main(String[] args) {
        arr = new int[]{1, 3, 5, 7, 9, 11};
        tree = new int[4 * arr.length];
        buildTree(1, 0, arr.length - 1);
        System.out.println("Sum of range(1,3): " + query(1, 0, arr.length - 1, 1, 3));
        update(1, 0, arr.length - 1, 1, 10);
        System.out.println("Updated Sum of range(1,3): " + query(1, 0, arr.length - 1, 1, 3));
    }
}

// day131_segment_tree.java
// Segment Tree for Range Sum Query and Update

public class day131_segment_tree {
    int[] tree;
    int n;

    public day131_segment_tree(int[] arr) {
        n = arr.length;
        tree = new int[4 * n];
        build(arr, 0, n - 1, 1);
    }

    void build(int[] arr, int start, int end, int node) {
        if (start == end) {
            tree[node] = arr[start];
            return;
        }
        int mid = (start + end) / 2;
        build(arr, start, mid, 2 * node);
        build(arr, mid + 1, end, 2 * node + 1);
        tree[node] = tree[2 * node] + tree[2 * node + 1];
    }

    void update(int index, int value, int start, int end, int node) {
        if (start == end) {
            tree[node] = value;
            return;
        }
        int mid = (start + end) / 2;
        if (index <= mid)
            update(index, value, start, mid, 2 * node);
        else
            update(index, value, mid + 1, end, 2 * node + 1);

        tree[node] = tree[2 * node] + tree[2 * node + 1];
    }

    int query(int l, int r, int start, int end, int node) {
        if (r < start || end < l)
            return 0;
        if (l <= start && end <= r)
            return tree[node];
        int mid = (start + end) / 2;
        return query(l, r, start, mid, 2 * node) + query(l, r, mid + 1, end, 2 * node + 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        day131_segment_tree st = new day131_segment_tree(arr);
        System.out.println("Sum of values in range [1,3]: " + st.query(1, 3, 0, arr.length - 1, 1));
        st.update(1, 10, 0, arr.length - 1, 1);
        System.out.println("Updated sum of values in range [1,3]: " + st.query(1, 3, 0, arr.length - 1, 1));
    }
}

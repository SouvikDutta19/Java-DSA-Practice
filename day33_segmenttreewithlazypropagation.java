public class day33_segmenttreewithlazypropagation {
    static int[] tree, lazy;

    public static void buildTree(int[] arr, int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;
            buildTree(arr, 2 * node, start, mid);
            buildTree(arr, 2 * node + 1, mid + 1, end);
            tree[node] = tree[2 * node] + tree[2 * node + 1];
        }
    }

    public static void updateRange(int node, int start, int end, int l, int r, int val) {
        if (lazy[node] != 0) {
            tree[node] += (end - start + 1) * lazy[node];
            if (start != end) {
                lazy[2 * node] += lazy[node];
                lazy[2 * node + 1] += lazy[node];
            }
            lazy[node] = 0;
        }

        if (start > end || start > r || end < l)
            return;

        if (start >= l && end <= r) {
            tree[node] += (end - start + 1) * val;
            if (start != end) {
                lazy[2 * node] += val;
                lazy[2 * node + 1] += val;
            }
            return;
        }

        int mid = (start + end) / 2;
        updateRange(2 * node, start, mid, l, r, val);
        updateRange(2 * node + 1, mid + 1, end, l, r, val);
        tree[node] = tree[2 * node] + tree[2 * node + 1];
    }

    public static int queryRange(int node, int start, int end, int l, int r) {
        if (start > end || start > r || end < l)
            return 0;

        if (lazy[node] != 0) {
            tree[node] += (end - start + 1) * lazy[node];
            if (start != end) {
                lazy[2 * node] += lazy[node];
                lazy[2 * node + 1] += lazy[node];
            }
            lazy[node] = 0;
        }

        if (start >= l && end <= r)
            return tree[node];

        int mid = (start + end) / 2;
        int left = queryRange(2 * node, start, mid, l, r);
        int right = queryRange(2 * node + 1, mid + 1, end, l, r);
        return left + right;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        int n = arr.length;
        tree = new int[4 * n];
        lazy = new int[4 * n];
        buildTree(arr, 1, 0, n - 1);

        System.out.println("Initial Range Sum (1-3): " + queryRange(1, 0, n - 1, 1, 3));
        updateRange(1, 0, n - 1, 1, 5, 10);
        System.out.println("Updated Range Sum (1-3): " + queryRange(1, 0, n - 1, 1, 3));
    }
}

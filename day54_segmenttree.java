class SegmentTree {
    private int[] tree;
    private int n;

    public SegmentTree(int[] arr) {
        n = arr.length;
        tree = new int[4 * n];
        build(arr, 0, n - 1, 1);
    }

    private void build(int[] arr, int start, int end, int node) {
        if (start == end) {
            tree[node] = arr[start];
            return;
        }
        int mid = (start + end) / 2;
        build(arr, start, mid, 2 * node);
        build(arr, mid + 1, end, 2 * node + 1);
        tree[node] = tree[2 * node] + tree[2 * node + 1];
    }

    public int query(int l, int r) {
        return query(0, n - 1, l, r, 1);
    }

    private int query(int start, int end, int l, int r, int node) {
        if (r < start || l > end) return 0;
        if (l <= start && end <= r) return tree[node];
        int mid = (start + end) / 2;
        return query(start, mid, l, r, 2 * node) + query(mid + 1, end, l, r, 2 * node + 1);
    }

    public void update(int idx, int val) {
        update(0, n - 1, idx, val, 1);
    }

    private void update(int start, int end, int idx, int val, int node) {
        if (start == end) {
            tree[node] = val;
            return;
        }
        int mid = (start + end) / 2;
        if (idx <= mid) update(start, mid, idx, val, 2 * node);
        else update(mid + 1, end, idx, val, 2 * node + 1);
        tree[node] = tree[2 * node] + tree[2 * node + 1];
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        SegmentTree segTree = new SegmentTree(arr);

        System.out.println("Sum of values in range(1,3): " + segTree.query(1, 3));
        segTree.update(1, 10);
        System.out.println("Updated sum of values in range(1,3): " + segTree.query(1, 3));
    }
}

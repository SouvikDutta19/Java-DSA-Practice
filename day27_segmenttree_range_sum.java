class SegmentTree {
    int[] tree;
    int n;

    public SegmentTree(int[] arr) {
        n = arr.length;
        tree = new int[4 * n];
        build(arr, 0, n - 1, 0);
    }

    private void build(int[] arr, int start, int end, int node) {
        if (start == end) {
            tree[node] = arr[start];
            return;
        }

        int mid = (start + end) / 2;
        build(arr, start, mid, 2 * node + 1);
        build(arr, mid + 1, end, 2 * node + 2);
        tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
    }

    public int query(int l, int r) {
        return queryUtil(0, n - 1, l, r, 0);
    }

    private int queryUtil(int start, int end, int l, int r, int node) {
        if (l <= start && r >= end) return tree[node];
        if (end < l || start > r) return 0;

        int mid = (start + end) / 2;
        return queryUtil(start, mid, l, r, 2 * node + 1) +
               queryUtil(mid + 1, end, l, r, 2 * node + 2);
    }

    public void update(int index, int value) {
        updateUtil(0, n - 1, index, value, 0);
    }

    private void updateUtil(int start, int end, int index, int value, int node) {
        if (start == end) {
            tree[node] = value;
            return;
        }

        int mid = (start + end) / 2;
        if (index <= mid)
            updateUtil(start, mid, index, value, 2 * node + 1);
        else
            updateUtil(mid + 1, end, index, value, 2 * node + 2);

        tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        SegmentTree st = new SegmentTree(arr);
        System.out.println("Sum of values in range [1,3]: " + st.query(1, 3));
        st.update(1, 10);
        System.out.println("Updated sum of values in range [1,3]: " + st.query(1, 3));
    }
}

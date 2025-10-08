public class day102_segmenttree {
    int[] tree;
    int n;

    public day102_segmenttree(int[] arr) {
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

    int query(int node, int start, int end, int l, int r) {
        if (r < start || end < l) return 0;
        if (l <= start && end <= r) return tree[node];
        int mid = (start + end) / 2;
        int left = query(2 * node, start, mid, l, r);
        int right = query(2 * node + 1, mid + 1, end, l, r);
        return left + right;
    }

    void update(int node, int start, int end, int idx, int val) {
        if (start == end) {
            tree[node] = val;
            return;
        }
        int mid = (start + end) / 2;
        if (idx <= mid) update(2 * node, start, mid, idx, val);
        else update(2 * node + 1, mid + 1, end, idx, val);
        tree[node] = tree[2 * node] + tree[2 * node + 1];
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        day102_segmenttree st = new day102_segmenttree(arr);
        System.out.println("Sum of range (1,3): " + st.query(1, 0, arr.length - 1, 1, 3));
        st.update(1, 0, arr.length - 1, 1, 10);
        System.out.println("Updated sum of range (1,3): " + st.query(1, 0, arr.length - 1, 1, 3));
    }
}

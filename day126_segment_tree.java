public class day126_segment_tree {
    int[] seg;
    int n;

    public day126_segment_tree(int[] arr) {
        n = arr.length;
        seg = new int[4 * n];
        build(arr, 0, 0, n - 1);
    }

    void build(int[] arr, int index, int low, int high) {
        if (low == high) {
            seg[index] = arr[low];
            return;
        }
        int mid = (low + high) / 2;
        build(arr, 2 * index + 1, low, mid);
        build(arr, 2 * index + 2, mid + 1, high);
        seg[index] = seg[2 * index + 1] + seg[2 * index + 2];
    }

    int query(int index, int low, int high, int l, int r) {
        if (r < low || high < l) return 0;
        if (l <= low && high <= r) return seg[index];
        int mid = (low + high) / 2;
        return query(2 * index + 1, low, mid, l, r) +
               query(2 * index + 2, mid + 1, high, l, r);
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 4, 9, 3};
        day126_segment_tree tree = new day126_segment_tree(arr);
        System.out.println("Sum in range [1,4]: " + tree.query(0, 0, arr.length - 1, 1, 4));
    }
}

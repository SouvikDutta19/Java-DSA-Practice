// day124_segment_tree_range_sum.java
public class day124_segment_tree_range_sum {
    private int[] seg;
    private int n;

    public day124_segment_tree_range_sum(int[] arr) {
        n = arr.length;
        seg = new int[4 * n];
        build(arr, 0, n - 1, 0);
    }

    private void build(int[] arr, int l, int r, int idx) {
        if (l == r) {
            seg[idx] = arr[l];
            return;
        }
        int mid = (l + r) / 2;
        build(arr, l, mid, 2 * idx + 1);
        build(arr, mid + 1, r, 2 * idx + 2);
        seg[idx] = seg[2 * idx + 1] + seg[2 * idx + 2];
    }

    public int query(int ql, int qr) { return queryUtil(0, n - 1, ql, qr, 0); }

    private int queryUtil(int l, int r, int ql, int qr, int idx) {
        if (ql > r || qr < l) return 0;
        if (ql <= l && r <= qr) return seg[idx];
        int mid = (l + r) / 2;
        return queryUtil(l, mid, ql, qr, 2 * idx + 1) + queryUtil(mid + 1, r, ql, qr, 2 * idx + 2);
    }

    public void update(int pos, int val) { updateUtil(0, n - 1, pos, val, 0); }

    private void updateUtil(int l, int r, int pos, int val, int idx) {
        if (l == r) {
            seg[idx] = val;
            return;
        }
        int mid = (l + r) / 2;
        if (pos <= mid) updateUtil(l, mid, pos, val, 2 * idx + 1);
        else updateUtil(mid + 1, r, pos, val, 2 * idx + 2);
        seg[idx] = seg[2 * idx + 1] + seg[2 * idx + 2];
    }

    public static void main(String[] args) {
        int[] arr = {2,5,1,4,9,3};
        day124_segment_tree_range_sum st = new day124_segment_tree_range_sum(arr);
        System.out.println("Sum [1,4] = " + st.query(1,4));
        st.update(2, 10);
        System.out.println("After update sum [1,4] = " + st.query(1,4));
    }
}

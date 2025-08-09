public class day40_segment_tree {
    static int[] st;

    static int build(int[] arr, int si, int ss, int se) {
        if (ss == se) return st[si] = arr[ss];
        int mid = (ss + se) / 2;
        return st[si] = build(arr, si * 2 + 1, ss, mid) + build(arr, si * 2 + 2, mid + 1, se);
    }

    static int query(int si, int ss, int se, int qs, int qe) {
        if (qs > se || qe < ss) return 0;
        if (qs <= ss && qe >= se) return st[si];
        int mid = (ss + se) / 2;
        return query(si * 2 + 1, ss, mid, qs, qe) + query(si * 2 + 2, mid + 1, se, qs, qe);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        int n = arr.length;
        st = new int[4 * n];
        build(arr, 0, 0, n - 1);
        System.out.println("Sum of values in range(1,3): " + query(0, 0, n - 1, 1, 3));
    }
}

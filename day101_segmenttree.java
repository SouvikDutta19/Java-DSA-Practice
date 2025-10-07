public class day101_segmenttree {
    int[] st;

    int constructST(int arr[], int l, int r, int si) {
        if (l == r) return st[si] = arr[l];
        int mid = (l + r) / 2;
        st[si] = constructST(arr, l, mid, si * 2 + 1) + constructST(arr, mid + 1, r, si * 2 + 2);
        return st[si];
    }

    int getSumUtil(int ss, int se, int qs, int qe, int si) {
        if (qs <= ss && qe >= se) return st[si];
        if (se < qs || ss > qe) return 0;
        int mid = (ss + se) / 2;
        return getSumUtil(ss, mid, qs, qe, 2 * si + 1) + getSumUtil(mid + 1, se, qs, qe, 2 * si + 2);
    }

    void updateValueUtil(int ss, int se, int i, int diff, int si) {
        if (i < ss || i > se) return;
        st[si] = st[si] + diff;
        if (se != ss) {
            int mid = (ss + se) / 2;
            updateValueUtil(ss, mid, i, diff, 2 * si + 1);
            updateValueUtil(mid + 1, se, i, diff, 2 * si + 2);
        }
    }

    void updateValue(int arr[], int n, int i, int new_val) {
        int diff = new_val - arr[i];
        arr[i] = new_val;
        updateValueUtil(0, n - 1, i, diff, 0);
    }

    int getSum(int n, int qs, int qe) { return getSumUtil(0, n - 1, qs, qe, 0); }

    public static void main(String args[]) {
        int arr[] = {1, 3, 5, 7, 9, 11};
        int n = arr.length;
        day101_segmenttree tree = new day101_segmenttree();
        int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
        int max_size = 2 * (int) Math.pow(2, x) - 1;
        tree.st = new int[max_size];
        tree.constructST(arr, 0, n - 1, 0);

        System.out.println("Sum of values in range 1 to 3 = " + tree.getSum(n, 1, 3));
        tree.updateValue(arr, n, 1, 10);
        System.out.println("Updated sum of values in range 1 to 3 = " + tree.getSum(n, 1, 3));
    }
}

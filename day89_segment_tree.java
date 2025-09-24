public class day89_segment_tree {
    int st[];
    int n;

    day89_segment_tree(int arr[], int n) {
        this.n = n;
        int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
        int max_size = 2 * (int) Math.pow(2, x) - 1;
        st = new int[max_size];
        constructST(arr, 0, n - 1, 0);
    }

    int constructST(int arr[], int ss, int se, int si) {
        if (ss == se) {
            st[si] = arr[ss];
            return arr[ss];
        }
        int mid = ss + (se - ss) / 2;
        st[si] = constructST(arr, ss, mid, si * 2 + 1) +
                 constructST(arr, mid + 1, se, si * 2 + 2);
        return st[si];
    }

    int getSum(int ss, int se, int qs, int qe, int si) {
        if (qs <= ss && qe >= se) return st[si];
        if (se < qs || ss > qe) return 0;
        int mid = ss + (se - ss) / 2;
        return getSum(ss, mid, qs, qe, 2 * si + 1) +
               getSum(mid + 1, se, qs, qe, 2 * si + 2);
    }

    public static void main(String args[]) {
        int arr[] = {1, 3, 5, 7, 9, 11};
        int n = arr.length;
        day89_segment_tree tree = new day89_segment_tree(arr, n);
        System.out.println("Sum of values in range(1,3): " +
            tree.getSum(0, n - 1, 1, 3, 0));
    }
}

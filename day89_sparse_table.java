public class day89_sparse_table {
    static int[][] st;
    static int[] log;

    static void preprocess(int arr[], int n) {
        log = new int[n + 1];
        for (int i = 2; i <= n; i++) log[i] = log[i / 2] + 1;

        int K = log[n] + 1;
        st = new int[n][K];
        for (int i = 0; i < n; i++) st[i][0] = arr[i];

        for (int j = 1; j < K; j++) {
            for (int i = 0; i + (1 << j) <= n; i++) {
                st[i][j] = Math.min(st[i][j - 1], st[i + (1 << (j - 1))][j - 1]);
            }
        }
    }

    static int query(int L, int R) {
        int j = log[R - L + 1];
        return Math.min(st[L][j], st[R - (1 << j) + 1][j]);
    }

    public static void main(String[] args) {
        int arr[] = {1, 3, 2, 7, 9, 11};
        int n = arr.length;
        preprocess(arr, n);
        System.out.println("Min between 1 and 5: " + query(1, 5));
    }
}

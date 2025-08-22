import java.util.*;

public class day53_sparse_table {
    static int[][] st;
    static int[] log;

    public static void buildSparseTable(int[] arr, int n) {
        log = new int[n + 1];
        for (int i = 2; i <= n; i++)
            log[i] = log[i / 2] + 1;

        int K = log[n];
        st = new int[n][K + 1];

        for (int i = 0; i < n; i++)
            st[i][0] = arr[i];

        for (int j = 1; j <= K; j++) {
            for (int i = 0; i + (1 << j) <= n; i++) {
                st[i][j] = Math.min(st[i][j - 1], st[i + (1 << (j - 1))][j - 1]);
            }
        }
    }

    public static int query(int L, int R) {
        int j = log[R - L + 1];
        return Math.min(st[L][j], st[R - (1 << j) + 1][j]);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, -1, 7, 0, 3, 4};
        buildSparseTable(arr, arr.length);
        System.out.println("Min in range [1,4]: " + query(1, 4));
        System.out.println("Min in range [2,6]: " + query(2, 6));
    }
}

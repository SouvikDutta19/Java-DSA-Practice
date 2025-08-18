import java.util.*;

public class day49_sparse_table {
    private int[][] st;
    private int[] log;

    public day49_sparse_table(int[] arr) {
        int n = arr.length;
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

    public int query(int L, int R) {
        int j = log[R - L + 1];
        return Math.min(st[L][j], st[R - (1 << j) + 1][j]);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, -2, 8, -7, 10};
        day49_sparse_table spt = new day49_sparse_table(arr);
        System.out.println("Min between [1,4]: " + spt.query(1, 4));
    }
}

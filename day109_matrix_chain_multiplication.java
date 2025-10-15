// Matrix Chain Multiplication using DP
public class day109_matrix_chain_multiplication {
    public static int matrixChainOrder(int[] p, int n) {
        int[][] dp = new int[n][n];
        for (int L = 2; L < n; L++)
            for (int i = 1; i < n - L + 1; i++) {
                int j = i + L - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int q = dp[i][k] + dp[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (q < dp[i][j]) dp[i][j] = q;
                }
            }
        return dp[1][n - 1];
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println("Minimum number of multiplications is " + matrixChainOrder(arr, arr.length));
    }
}

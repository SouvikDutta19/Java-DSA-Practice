import java.util.*;

// Program to find the minimum number of multiplications needed to multiply a chain of matrices
public class day103_matrix_chain_multiplication {

    // Recursive + Memoization approach
    static int matrixChainOrder(int[] arr, int i, int j, int[][] dp) {
        if (i == j)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        dp[i][j] = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            int cost = matrixChainOrder(arr, i, k, dp) +
                       matrixChainOrder(arr, k + 1, j, dp) +
                       arr[i - 1] * arr[k] * arr[j];

            if (cost < dp[i][j])
                dp[i][j] = cost;
        }

        return dp[i][j];
    }

    // Bottom-up Dynamic Programming approach
    static int matrixChainOrderDP(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];

        for (int len = 2; len < n; len++) {
            for (int i = 1; i < n - len + 1; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + arr[i - 1] * arr[k] * arr[j];
                    if (cost < dp[i][j])
                        dp[i][j] = cost;
                }
            }
        }
        return dp[1][n - 1];
    }

    public static void main(String[] args) {
        int[] dimensions = { 40, 20, 30, 10, 30 };
        int n = dimensions.length;

        int[][] dp = new int[n][n];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        int minCostMemo = matrixChainOrder(dimensions, 1, n - 1, dp);
        int minCostDP = matrixChainOrderDP(dimensions);

        System.out.println("Minimum number of multiplications (Memoization): " + minCostMemo);
        System.out.println("Minimum number of multiplications (DP): " + minCostDP);
    }
}

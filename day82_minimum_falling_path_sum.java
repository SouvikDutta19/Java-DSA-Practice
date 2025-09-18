public class day82_minimum_falling_path_sum {
    public static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for (int j = 0; j < n; j++) dp[0][j] = matrix[0][j];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = matrix[i][j] + dp[i - 1][j];
                if (j > 0) dp[i][j] = Math.min(dp[i][j], matrix[i][j] + dp[i - 1][j - 1]);
                if (j < n - 1) dp[i][j] = Math.min(dp[i][j], matrix[i][j] + dp[i - 1][j + 1]);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) min = Math.min(min, dp[n - 1][j]);
        return min;
    }

    public static void main(String[] args) {
        int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
        System.out.println("Min Falling Path Sum: " + minFallingPathSum(matrix));
    }
}

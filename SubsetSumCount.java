public class SubsetSumCount {
    public static int countSubsets(int[] arr, int n, int sum) {
        int[][] dp = new int[n+1][sum+1];
        for (int i = 0; i <= n; i++) dp[i][0] = 1;

        for (int i = 1; i <= n; i++)
            for (int j = 0; j <= sum; j++)
                if (arr[i-1] <= j)
                    dp[i][j] = dp[i-1][j-arr[i-1]] + dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j];

        return dp[n][sum];
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 6, 8, 10};
        int sum = 10;
        System.out.println("Count of subsets: " + countSubsets(arr, arr.length, sum));
    }
}

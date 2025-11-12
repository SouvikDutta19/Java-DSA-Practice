public class day136_knapsack_memoization {
    static int[][] dp;

    static int knapSack(int W, int wt[], int val[], int n) {
        if (n == 0 || W == 0)
            return 0;
        if (dp[n][W] != -1)
            return dp[n][W];

        if (wt[n - 1] <= W)
            return dp[n][W] = Math.max(val[n - 1] + knapSack(W - wt[n - 1], wt, val, n - 1),
                    knapSack(W, wt, val, n - 1));
        else
            return dp[n][W] = knapSack(W, wt, val, n - 1);
    }

    public static void main(String[] args) {
        int[] val = {60, 100, 120};
        int[] wt = {10, 20, 30};
        int W = 50;
        dp = new int[val.length + 1][W + 1];
        for (int i = 0; i < dp.length; i++)
            java.util.Arrays.fill(dp[i], -1);
        System.out.println("Maximum value: " + knapSack(W, wt, val, val.length));
    }
}

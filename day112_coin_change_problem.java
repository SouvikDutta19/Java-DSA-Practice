// Program to find the total number of ways to make change using given coins (Coin Change Problem)

public class day112_coin_change_problem {
    public static int countWays(int[] coins, int n, int sum) {
        int[] dp = new int[sum + 1];
        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= sum; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[sum];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int sum = 5;
        System.out.println("Number of ways to make change: " + countWays(coins, coins.length, sum));
    }
}

import java.util.*;

public class day144_coin_change_ways {

    public static int countWays(int[] coins, int sum) {
        int n = coins.length;
        int[] dp = new int[sum + 1];

        dp[0] = 1;

        for (int coin : coins) {
            for (int j = coin; j <= sum; j++) {
                dp[j] += dp[j - coin];
            }
        }

        return dp[sum];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int sum = 5;
        System.out.println("Total Ways to Make Sum: " + countWays(coins, sum));
    }
}

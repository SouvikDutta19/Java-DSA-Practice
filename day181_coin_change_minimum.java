import java.util.*;

public class day181_coin_change_minimum {

    public static int minCoins(int[] coins, int amt) {
        int[] dp = new int[amt + 1];
        Arrays.fill(dp, amt + 1);
        dp[0] = 0;

        for (int i = 1; i <= amt; i++) {
            for (int c : coins) {
                if (c <= i)
                    dp[i] = Math.min(dp[i], dp[i - c] + 1);
            }
        }
        return dp[amt] > amt ? -1 : dp[amt];
    }

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        System.out.println(minCoins(coins, 11));
    }
}
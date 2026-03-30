public class day205_coin_change {

    public static int coinChange(int[] coins, int amount){

        int[] dp = new int[amount+1];

        for(int i=1;i<=amount;i++){
            dp[i] = Integer.MAX_VALUE;
            for(int coin : coins){
                if(i-coin >= 0 && dp[i-coin] != Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i], dp[i-coin] + 1);
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
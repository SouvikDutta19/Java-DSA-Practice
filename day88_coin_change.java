public class day88_coin_change {
    static int coinChange(int[] coins, int amount) {
        int[] dp=new int[amount+1];
        for(int i=1;i<=amount;i++) dp[i]=amount+1;
        dp[0]=0;
        for(int c:coins){
            for(int i=c;i<=amount;i++){
                dp[i]=Math.min(dp[i],dp[i-c]+1);
            }
        }
        return dp[amount]>amount?-1:dp[amount];
    }

    public static void main(String[] args){
        int[] coins={1,2,5};
        System.out.println(coinChange(coins,11));
    }
}

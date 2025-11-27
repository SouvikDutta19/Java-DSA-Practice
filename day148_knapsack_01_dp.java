// Day148 0/1 Knapsack (DP)
public class Day148KnapSack01DP {
    public static int knapSack(int W, int[] wt, int[] val){
        int n = wt.length;
        int[] dp = new int[W+1];
        for(int i=0;i<n;i++){
            for(int w=W; w>=wt[i]; w--){
                dp[w] = Math.max(dp[w], dp[w-wt[i]] + val[i]);
            }
        }
        return dp[W];
    }

    public static void main(String[] args){
        int[] val = {60,100,120};
        int[] wt = {10,20,30};
        int W = 50;
        System.out.println("Max value = " + knapSack(W, wt, val)); // 220
    }
}

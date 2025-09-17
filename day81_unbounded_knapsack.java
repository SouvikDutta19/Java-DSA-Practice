public class day81_unbounded_knapsack {
    public static int unboundedKnapsack(int W,int[] val,int[] wt,int n) {
        int[] dp=new int[W+1];
        for(int i=0;i<=W;i++) {
            for(int j=0;j<n;j++) {
                if(wt[j]<=i)
                    dp[i]=Math.max(dp[i],val[j]+dp[i-wt[j]]);
            }
        }
        return dp[W];
    }

    public static void main(String[] args) {
        int[] val={10,40,50,70}, wt={1,3,4,5};
        System.out.println("Unbounded Knapsack: "+unboundedKnapsack(8,val,wt,val.length));
    }
}

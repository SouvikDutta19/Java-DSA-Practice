public class day88_edit_distance {
    static int minDistance(String w1, String w2) {
        int m=w1.length(), n=w2.length();
        int[][] dp=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0) dp[i][j]=j;
                else if(j==0) dp[i][j]=i;
                else if(w1.charAt(i-1)==w2.charAt(j-1)) dp[i][j]=dp[i-1][j-1];
                else dp[i][j]=1+Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args){
        System.out.println(minDistance("horse","ros"));
    }
}

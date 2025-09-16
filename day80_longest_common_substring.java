public class day80_longest_common_substring {
    public static int LCSubStr(String X,String Y,int m,int n) {
        int[][] dp=new int[m+1][n+1];
        int result=0;
        for(int i=0;i<=m;i++) {
            for(int j=0;j<=n;j++) {
                if(i==0 || j==0) dp[i][j]=0;
                else if(X.charAt(i-1)==Y.charAt(j-1)) {
                    dp[i][j]=dp[i-1][j-1]+1;
                    result=Math.max(result,dp[i][j]);
                } else dp[i][j]=0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Longest Common Substring: " + LCSubStr("ABABC","BABCAC",5,6));
    }
}

public class LongestCommonSubstring {

    public static int longestCommonSubstring(String X, String Y) {
        int m = X.length(), n = Y.length();
        int[][] dp = new int[m+1][n+1];
        int maxLength = 0;

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (X.charAt(i-1) == Y.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    maxLength = Math.max(maxLength, dp[i][j]);
                } else
                    dp[i][j] = 0;
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String X = "abcdfgh";
        String Y = "abedfhr";
        System.out.println("Length of Longest Common Substring: " + longestCommonSubstring(X, Y));
    }
}

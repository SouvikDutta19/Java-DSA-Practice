public class day32_distinctsubsequences {
    public static int numDistinct(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];

        for (int j = 0; j <= s.length(); j++)
            dp[0][j] = 1;

        for (int i = 1; i <= t.length(); i++) {
            for (int j = 1; j <= s.length(); j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1))
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
                else
                    dp[i][j] = dp[i][j - 1];
            }
        }

        return dp[t.length()][s.length()];
    }

    public static void main(String[] args) {
        String s = "babgbag", t = "bag";
        System.out.println("Number of distinct subsequences: " + numDistinct(s, t)); // Output: 5
    }
}

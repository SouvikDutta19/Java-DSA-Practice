import java.util.*;

// Longest Palindromic Subsequence using DP
public class day108_longest_palindromic_subsequence {
    static int lps(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) dp[i][i] = 1;

        for (int cl = 2; cl <= n; cl++)
            for (int i = 0; i < n - cl + 1; i++) {
                int j = i + cl - 1;
                if (s.charAt(i) == s.charAt(j) && cl == 2)
                    dp[i][j] = 2;
                else if (s.charAt(i) == s.charAt(j))
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                else
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
            }

        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        String seq = "bbbab";
        System.out.println("Length of LPS: " + lps(seq));
    }
}

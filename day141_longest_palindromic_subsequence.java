// day141_longest_palindromic_subsequence.java
// Finds length and also reconstructs one LPS.

import java.util.*;

public class day141_longest_palindromic_subsequence {

    public static int longestPalindromicSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int i = n-1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i+1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + (i+1 <= j-1 ? dp[i+1][j-1] : 0);
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }

        System.out.println("LPS length: " + dp[0][n-1]);
        System.out.println("One LPS: " + reconstruct(s, dp));
        return dp[0][n-1];
    }

    private static String reconstruct(String s, int[][] dp) {
        int i = 0, j = s.length() - 1;
        StringBuilder left = new StringBuilder();
        StringBuilder right = new StringBuilder();

        while (i <= j) {
            if (s.charAt(i) == s.charAt(j)) {
                if (i == j) { // middle char for odd length
                    left.append(s.charAt(i));
                } else {
                    left.append(s.charAt(i));
                    right.append(s.charAt(j));
                }
                i++; j--;
            } else if (dp[i+1][j] >= dp[i][j-1]) {
                i++;
            } else {
                j--;
            }
        }
        return left.toString() + right.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "bbbab";
        longestPalindromicSubseq(s);
    }
}

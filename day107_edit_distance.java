import java.util.*;

// Edit Distance (Levenshtein Distance) using Dynamic Programming
public class day107_edit_distance {
    public static int editDistance(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++)
            for (int j = 0; j <= n; j++) {
                if (i == 0) dp[i][j] = j;
                else if (j == 0) dp[i][j] = i;
                else if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1],
                            Math.min(dp[i - 1][j], dp[i][j - 1]));
            }

        return dp[m][n];
    }

    public static void main(String[] args) {
        String s1 = "kitten", s2 = "sitting";
        System.out.println("Edit Distance: " + editDistance(s1, s2));
    }
}

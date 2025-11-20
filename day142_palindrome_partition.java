import java.util.*;

public class day142_palindrome_partition {

    public static int minCut(String s) {
        int n = s.length();
        boolean[][] isPal = new boolean[n][n];

        for (int g = 0; g < n; g++) {
            for (int i = 0, j = g; j < n; i++, j++) {
                if (g == 0)
                    isPal[i][j] = true;
                else if (g == 1)
                    isPal[i][j] = s.charAt(i) == s.charAt(j);
                else
                    isPal[i][j] = s.charAt(i) == s.charAt(j) && isPal[i + 1][j - 1];
            }
        }

        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            if (isPal[0][i]) {
                dp[i] = 0;
            } else {
                dp[i] = Integer.MAX_VALUE;
                for (int j = i; j >= 1; j--) {
                    if (isPal[j][i]) {
                        dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                    }
                }
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        String s = "aab";
        System.out.println("Minimum Cuts: " + minCut(s));
    }
}

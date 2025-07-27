public class ShortestCommonSupersequence {
    public static String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        int[][] dp = new int[m + 1][n + 1];

        // Build LCS table
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (str1.charAt(i) == str2.charAt(j))
                    dp[i + 1][j + 1] = 1 + dp[i][j];
                else
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
            }
        }

        // Build SCS from LCS table
        StringBuilder sb = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                sb.append(str1.charAt(i - 1));
                i--; j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                sb.append(str1.charAt(i - 1));
                i--;
            } else {
                sb.append(str2.charAt(j - 1));
                j--;
            }
        }
        while (i > 0) sb.append(str1.charAt(--i));
        while (j > 0) sb.append(str2.charAt(--j));

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String str1 = "abac";
        String str2 = "cab";
        System.out.println("Shortest Common Supersequence: " + shortestCommonSupersequence(str1, str2));
    }
}

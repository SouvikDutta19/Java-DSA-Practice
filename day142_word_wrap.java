import java.util.*;

public class day142_word_wrap {

    public static void wordWrap(int[] words, int maxWidth) {
        int n = words.length;

        int[][] cost = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            cost[i][i] = maxWidth - words[i - 1];
            for (int j = i + 1; j <= n; j++) {
                cost[i][j] = cost[i][j - 1] - words[j - 1] - 1;
            }
        }

        for (int i = 1; i <= n; i++)
            for (int j = i; j <= n; j++)
                if (cost[i][j] < 0)
                    cost[i][j] = Integer.MAX_VALUE;
                else
                    cost[i][j] = (j == n) ? 0 : cost[i][j] * cost[i][j];

        int[] dp = new int[n + 1];
        int[] ans = new int[n + 1];

        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j <= i; j++) {
                if (dp[j - 1] != Integer.MAX_VALUE && cost[j][i] != Integer.MAX_VALUE &&
                        dp[j - 1] + cost[j][i] < dp[i]) {
                    dp[i] = dp[j - 1] + cost[j][i];
                    ans[i] = j;
                }
            }
        }

        int i = n;
        List<String> lines = new ArrayList<>();
        while (i > 0) {
            int j = ans[i];
            lines.add(j + " " + i);
            i = j - 1;
        }

        Collections.reverse(lines);

        System.out.println("Word Wrap Lines:");
        for (String s : lines)
            System.out.println(s);
    }

    public static void main(String[] args) {
        int[] words = {3, 2, 2, 5};
        int maxWidth = 6;
        wordWrap(words, maxWidth);
    }
}

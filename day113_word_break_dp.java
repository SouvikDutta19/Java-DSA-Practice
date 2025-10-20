// Program to solve Word Break Problem using Dynamic Programming

import java.util.*;

public class day113_word_break_dp {
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        List<String> dict = Arrays.asList("leet", "code");
        System.out.println("Can be segmented: " + wordBreak("leetcode", dict));
    }
}

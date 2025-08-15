import java.util.*;

public class day46_wordbreakproblem {

    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        List<String> wordDict = Arrays.asList("leet", "code", "apple", "pen");
        String s1 = "leetcode";
        String s2 = "applepenapple";
        String s3 = "catsandog";

        System.out.println("Word Break for leetcode: " + wordBreak(s1, wordDict));
        System.out.println("Word Break for applepenapple: " + wordBreak(s2, wordDict));
        System.out.println("Word Break for catsandog: " + wordBreak(s3, wordDict));
    }
}

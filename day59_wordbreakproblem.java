import java.util.*;

class WordBreakProblem {
    public static boolean wordBreak(String s, List<String> dict) {
        Set<String> set = new HashSet<>(dict);
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
        List<String> dict = Arrays.asList("leet", "code", "apple", "pen");
        String s1 = "leetcode";
        String s2 = "applepenapple";

        System.out.println(s1 + " can be segmented? " + wordBreak(s1, dict));
        System.out.println(s2 + " can be segmented? " + wordBreak(s2, dict));
    }
}

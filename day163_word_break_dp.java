import java.util.*;

public class day163_word_break_dp {

    public static boolean wordBreak(String s, Set<String> dict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        String s = "leetcode";
        Set<String> dict = new HashSet<>(Arrays.asList("leet", "code"));

        System.out.println("Can break word? " + wordBreak(s, dict));
    }
}
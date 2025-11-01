import java.util.*;

public class day125_word_break {

    static boolean wordBreak(String s, List<String> dict) {
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
        List<String> dict = Arrays.asList("leet", "code", "is", "fun");
        System.out.println(wordBreak("leetcodeisfun", dict));
    }
}

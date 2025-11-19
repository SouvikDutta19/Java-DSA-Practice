// day141_word_break_all_sentences.java
// Generates all sentences that segment the string into dictionary words (Word Break II).
// Uses memoization to avoid recomputation.

import java.util.*;

public class day141_word_break_all_sentences {

    public static List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        Map<Integer, List<String>> memo = new HashMap<>();
        return dfs(s, 0, dict, memo);
    }

    private static List<String> dfs(String s, int idx, Set<String> dict, Map<Integer, List<String>> memo) {
        if (memo.containsKey(idx)) return memo.get(idx);
        List<String> res = new ArrayList<>();
        if (idx == s.length()) {
            res.add("");
            return res;
        }

        for (int end = idx + 1; end <= s.length(); end++) {
            String pref = s.substring(idx, end);
            if (dict.contains(pref)) {
                List<String> suffixes = dfs(s, end, dict, memo);
                for (String suf : suffixes) {
                    if (suf.isEmpty()) res.add(pref);
                    else res.add(pref + " " + suf);
                }
            }
        }
        memo.put(idx, res);
        return res;
    }

    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> dict = Arrays.asList("cat","cats","and","sand","dog");
        List<String> res = wordBreak(s, dict);
        for (String sentence : res) System.out.println(sentence);
    }
}

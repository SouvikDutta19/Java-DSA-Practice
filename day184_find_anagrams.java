import java.util.*;

public class day184_find_anagrams {

    static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) return res;

        int[] cnt = new int[26];
        for (char c : p.toCharArray()) cnt[c - 'a']++;

        int left = 0, right = 0, needed = p.length();

        while (right < s.length()) {
            if (cnt[s.charAt(right++) - 'a']-- > 0)
                needed--;

            if (needed == 0) res.add(left);

            if (right - left == p.length() &&
                cnt[s.charAt(left++) - 'a']++ >= 0)
                needed++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }
}
import java.util.*;

public class day164_minimum_window_substring {

    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        Map<Character, Integer> freq = new HashMap<>();
        for (char c : t.toCharArray())
            freq.put(c, freq.getOrDefault(c, 0) + 1);

        int left = 0, count = 0, minLen = Integer.MAX_VALUE, start = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (freq.containsKey(c)) {
                freq.put(c, freq.get(c) - 1);
                if (freq.get(c) >= 0) count++;
            }

            while (count == t.length()) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char l = s.charAt(left++);
                if (freq.containsKey(l)) {
                    freq.put(l, freq.get(l) + 1);
                    if (freq.get(l) > 0) count--;
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }
}
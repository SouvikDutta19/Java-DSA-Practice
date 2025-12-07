import java.util.*;

public class day157_minimum_window_substring {

    static String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        int start = 0, minLen = Integer.MAX_VALUE, left = 0, count = 0;
        int[] freq = new int[256];

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            freq[c]++;

            if (map.containsKey(c) && freq[c] <= map.get(c))
                count++;

            while (count == t.length()) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);
                freq[leftChar]--;

                if (map.containsKey(leftChar) && freq[leftChar] < map.get(leftChar))
                    count--;

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println("Minimum Window: " + minWindow(s, t));
    }
}
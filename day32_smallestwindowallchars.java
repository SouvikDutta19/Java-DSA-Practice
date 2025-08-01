import java.util.*;

public class day32_smallestwindowallchars {
    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        int left = 0, right = 0, count = map.size();
        int minLen = Integer.MAX_VALUE, minStart = 0;

        while (right < s.length()) {
            char c = s.charAt(right++);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0)
                    count--;
            }

            while (count == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    minStart = left;
                }

                char ch = s.charAt(left++);
                if (map.containsKey(ch)) {
                    map.put(ch, map.get(ch) + 1);
                    if (map.get(ch) > 0)
                        count++;
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println("Minimum window: " + minWindow(s, t)); // Output: BANC
    }
}

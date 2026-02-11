import java.util.HashMap;

public class Day188MinimumWindowSubstring {

    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        int left = 0, right = 0, required = t.length();
        int minLen = Integer.MAX_VALUE, start = 0;

        while (right < s.length()) {
            char r = s.charAt(right);
            if (map.containsKey(r)) {
                if (map.get(r) > 0) required--;
                map.put(r, map.get(r) - 1);
            }
            right++;

            while (required == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }

                char l = s.charAt(left);
                if (map.containsKey(l)) {
                    map.put(l, map.get(l) + 1);
                    if (map.get(l) > 0) required++;
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" :
                s.substring(start, start + minLen);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }
}
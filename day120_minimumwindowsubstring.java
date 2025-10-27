// day120_minimumwindowsubstring.java
import java.util.*;

public class day120_minimumwindowsubstring {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";

        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        int left = 0, right = 0, count = map.size();
        int minLen = Integer.MAX_VALUE, start = 0;

        while (right < s.length()) {
            char c = s.charAt(right++);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) count--;
            }

            while (count == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }

                char temp = s.charAt(left++);
                if (map.containsKey(temp)) {
                    if (map.get(temp) == 0) count++;
                    map.put(temp, map.get(temp) + 1);
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

    public static void main(String[] args) {
        day120_minimumwindowsubstring obj = new day120_minimumwindowsubstring();
        System.out.println(obj.minWindow("ADOBECODEBANC", "ABC"));
    }
}

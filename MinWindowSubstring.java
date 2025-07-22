import java.util.*;

public class MinWindowSubstring {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";

        Map<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);

        int left = 0, right = 0, minLen = Integer.MAX_VALUE, start = 0, count = t.length();

        while(right < s.length()) {
            if(map.containsKey(s.charAt(right))) {
                if(map.get(s.charAt(right)) > 0) count--;
                map.put(s.charAt(right), map.get(s.charAt(right)) - 1);
            }
            right++;

            while(count == 0) {
                if(right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }
                if(map.containsKey(s.charAt(left))) {
                    map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                    if(map.get(s.charAt(left)) > 0) count++;
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

    public static void main(String[] args) {
        MinWindowSubstring obj = new MinWindowSubstring();
        System.out.println(obj.minWindow("ADOBECODEBANC", "ABC"));  // BANC
    }
}

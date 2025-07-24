import java.util.*;

public class LongestSubstringNoRepeat {
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int max = 0, i = 0, j = 0;
        while (i < s.length() && j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String input = "abcabcbb";
        System.out.println("Length: " + lengthOfLongestSubstring(input));
    }
}

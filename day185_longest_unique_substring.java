import java.util.HashMap;

public class Day185LongestUniqueSubstring {

    public static int longestUniqueSubstring(String s) {
        HashMap<Character, Integer> lastIndex = new HashMap<>();
        int left = 0, maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);

            if (lastIndex.containsKey(current) && lastIndex.get(current) >= left) {
                left = lastIndex.get(current) + 1;
            }

            lastIndex.put(current, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println("Longest unique substring length: " + longestUniqueSubstring(s));
    }
}
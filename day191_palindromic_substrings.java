public class Day191PalindromicSubstrings {

    public static int countSubstrings(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            count += expand(s, i, i);
            count += expand(s, i, i + 1);
        }

        return count;
    }

    private static int expand(String s, int left, int right) {
        int count = 0;

        while (left >= 0 && right < s.length() &&
               s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("aaa"));
    }
}
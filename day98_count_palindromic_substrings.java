public class day98_count_palindromic_substrings {
    public static int countSubstrings(String s) {
        int n = s.length(), count = 0;
        for (int center = 0; center < 2 * n - 1; center++) {
            int left = center / 2, right = left + center % 2;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                count++;
                left--;
                right++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("Count: " + countSubstrings("aaa"));
    }
}

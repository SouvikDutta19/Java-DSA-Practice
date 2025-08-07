import java.util.Arrays;

public class day38_printlongestrepeatsubstring {
    public static String longestRepeatedSubstring(String str) {
        int n = str.length();
        String[] suffixes = new String[n];
        for (int i = 0; i < n; i++) suffixes[i] = str.substring(i);
        Arrays.sort(suffixes);
        String res = "";
        for (int i = 0; i < n - 1; i++) {
            String lcp = LCP(suffixes[i], suffixes[i + 1]);
            if (lcp.length() > res.length()) res = lcp;
        }
        return res;
    }

    private static String LCP(String s1, String s2) {
        int n = Math.min(s1.length(), s2.length());
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) return s1.substring(0, i);
        }
        return s1.substring(0, n);
    }

    public static void main(String[] args) {
        String str = "banana";
        System.out.println("Longest Repeated Substring: " + longestRepeatedSubstring(str));
    }
}

// day138_kmp_pattern_search.java
public class day138_kmp_pattern_search {

    public static int[] buildLPS(String pattern) {
        int[] lps = new int[pattern.length()];
        int j = 0;

        for (int i = 1; i < pattern.length(); i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j))
                j = lps[j - 1];

            if (pattern.charAt(i) == pattern.charAt(j))
                j++;

            lps[i] = j;
        }
        return lps;
    }

    public static void search(String text, String pattern) {
        int[] lps = buildLPS(pattern);
        int i = 0, j = 0;

        while (i < text.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++; j++;
            }
            if (j == pattern.length()) {
                System.out.println("Pattern found at index: " + (i - j));
                j = lps[j - 1];
            } else if (i < text.length() && text.charAt(i) != pattern.charAt(j)) {
                if (j != 0) j = lps[j - 1];
                else i++;
            }
        }
    }

    public static void main(String[] args) {
        search("abxabcabcaby", "abcaby");
    }
}

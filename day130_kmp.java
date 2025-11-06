// day130_kmp.java
// KMP (Knuth-Morris-Pratt) pattern searching algorithm

public class day130_kmp {

    private static int[] computeLPS(String pat) {
        int m = pat.length();
        int[] lps = new int[m];
        int len = 0;
        lps[0] = 0;
        int i = 1;
        while (i < m) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    public static void KMPSearch(String txt, String pat) {
        int n = txt.length(), m = pat.length();
        if (m == 0) {
            System.out.println("Empty pattern.");
            return;
        }
        int[] lps = computeLPS(pat);
        int i = 0, j = 0;
        while (i < n) {
            if (txt.charAt(i) == pat.charAt(j)) {
                i++; j++;
            }
            if (j == m) {
                System.out.println("Found pattern at index " + (i - j));
                j = lps[j - 1];
            } else if (i < n && txt.charAt(i) != pat.charAt(j)) {
                if (j != 0) j = lps[j - 1];
                else i++;
            }
        }
    }

    public static void main(String[] args) {
        String txt = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";
        KMPSearch(txt, pat);
    }
}

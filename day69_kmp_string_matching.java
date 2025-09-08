import java.util.*;

public class day69_kmp_string_matching {
    static int[] computeLPS(String pat) {
        int n = pat.length(), len = 0, i = 1;
        int[] lps = new int[n];
        while (i < n) {
            if (pat.charAt(i) == pat.charAt(len)) {
                lps[i++] = ++len;
            } else {
                if (len != 0) len = lps[len - 1];
                else lps[i++] = 0;
            }
        }
        return lps;
    }

    static void KMP(String txt, String pat) {
        int[] lps = computeLPS(pat);
        int i = 0, j = 0, N = txt.length(), M = pat.length();
        while (i < N) {
            if (pat.charAt(j) == txt.charAt(i)) {
                i++; j++;
            }
            if (j == M) {
                System.out.println("Pattern found at index " + (i - j));
                j = lps[j - 1];
            } else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0) j = lps[j - 1];
                else i++;
            }
        }
    }

    public static void main(String[] args) {
        KMP("abxabcabcaby", "abcaby");
    }
}

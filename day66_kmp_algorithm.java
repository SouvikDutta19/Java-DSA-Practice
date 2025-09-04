import java.util.*;

public class day66_kmp_algorithm {
    static int[] buildLPS(String pat) {
        int n = pat.length(), len = 0, i = 1;
        int[] lps = new int[n];
        while (i < n) {
            if (pat.charAt(i) == pat.charAt(len)) {
                lps[i++] = ++len;
            } else if (len != 0) len = lps[len-1];
            else lps[i++] = 0;
        }
        return lps;
    }

    static List<Integer> search(String txt, String pat) {
        int[] lps = buildLPS(pat);
        int i = 0, j = 0;
        List<Integer> res = new ArrayList<>();
        while (i < txt.length()) {
            if (pat.charAt(j) == txt.charAt(i)) { i++; j++; }
            if (j == pat.length()) {
                res.add(i - j);
                j = lps[j-1];
            } else if (i < txt.length() && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0) j = lps[j-1];
                else i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String txt = "ababcababcabc";
        String pat = "abc";
        System.out.println(search(txt, pat));
    }
}

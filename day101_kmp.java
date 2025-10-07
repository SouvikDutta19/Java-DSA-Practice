public class day101_kmp {
    void KMPSearch(String pat, String txt) {
        int M = pat.length(), N = txt.length();
        int lps[] = new int[M];
        computeLPSArray(pat, M, lps);
        int i = 0, j = 0;

        while (i < N) {
            if (pat.charAt(j) == txt.charAt(i)) { i++; j++; }
            if (j == M) {
                System.out.println("Found pattern at index " + (i - j));
                j = lps[j - 1];
            } else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                j = (j != 0) ? lps[j - 1] : 0;
            }
        }
    }

    void computeLPSArray(String pat, int M, int lps[]) {
        int len = 0, i = 1;
        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                lps[i++] = ++len;
            } else if (len != 0) {
                len = lps[len - 1];
            } else {
                lps[i++] = 0;
            }
        }
    }

    public static void main(String[] args) {
        new day101_kmp().KMPSearch("ABABCABAB", "ABABDABACDABABCABAB");
    }
}

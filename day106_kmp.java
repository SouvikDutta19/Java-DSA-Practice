// KMP Pattern Matching Algorithm
public class day106_kmp {
    public void KMPSearch(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();
        int[] lps = new int[M];
        computeLPSArray(pat, M, lps);

        int i = 0; // index for txt
        int j = 0; // index for pat
        while (i < N) {
            if (pat.charAt(j) == txt.charAt(i)) {
                i++; j++;
            }
            if (j == M) {
                System.out.println("Found pattern at index " + (i - j));
                j = lps[j - 1];
            } else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0) j = lps[j - 1];
                else i++;
            }
        }
    }

    private void computeLPSArray(String pat, int M, int[] lps) {
        int len = 0;
        lps[0] = 0;
        int i = 1;
        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) len = lps[len - 1];
                else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }

    public static void main(String[] args) {
        day106_kmp kmp = new day106_kmp();
        String txt = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";
        kmp.KMPSearch(pat, txt);
    }
}

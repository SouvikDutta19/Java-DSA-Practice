public class day70_kmp_pattern_matching {
    static void KMPSearch(String pat, String txt) {
        int m = pat.length(), n = txt.length();
        int[] lps = new int[m];
        computeLPS(pat, m, lps);

        int i=0,j=0;
        while (i < n) {
            if (pat.charAt(j) == txt.charAt(i)) { i++; j++; }
            if (j == m) {
                System.out.println("Pattern found at index " + (i - j));
                j = lps[j - 1];
            } else if (i < n && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0) j = lps[j - 1]; else i++;
            }
        }
    }

    static void computeLPS(String pat, int m, int[] lps) {
        int len=0,i=1; lps[0]=0;
        while (i < m) {
            if (pat.charAt(i)==pat.charAt(len)) lps[i++]=++len;
            else if (len!=0) len=lps[len-1];
            else lps[i++]=0;
        }
    }

    public static void main(String[] args) {
        KMPSearch("abc", "abxabcabcaby");
    }
}

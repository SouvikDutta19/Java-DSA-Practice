public class day156_rabin_karp_pattern_search {

    static final int d = 256;
    static final int q = 101;

    static void search(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();
        int p = 0, t = 0, h = 1;
        int i, j;

        for (i = 0; i < M - 1; i++)
            h = (h * d) % q;

        for (i = 0; i < M; i++) {
            p = (d * p + pat.charAt(i)) % q;
            t = (d * t + txt.charAt(i)) % q;
        }

        for (i = 0; i <= N - M; i++) {
            if (p == t) {
                for (j = 0; j < M; j++) {
                    if (txt.charAt(i + j) != pat.charAt(j))
                        break;
                }
                if (j == M)
                    System.out.println("Pattern found at index " + i);
            }

            if (i < N - M) {
                t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + 1)) % q;

                if (t < 0) t += q;
            }
        }
    }

    public static void main(String[] args) {
        String txt = "ABCCDDAEFG";
        String pat = "CDD";
        search(pat, txt);
    }
}
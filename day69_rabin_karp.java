public class day69_rabin_karp {
    static final int d = 256;
    static final int q = 101;

    static void search(String pat, String txt) {
        int M = pat.length(), N = txt.length();
        int p = 0, t = 0, h = 1;
        for (int i = 0; i < M - 1; i++) h = (h * d) % q;
        for (int i = 0; i < M; i++) {
            p = (d * p + pat.charAt(i)) % q;
            t = (d * t + txt.charAt(i)) % q;
        }
        for (int i = 0; i <= N - M; i++) {
            if (p == t) {
                if (txt.substring(i, i + M).equals(pat))
                    System.out.println("Pattern found at index " + i);
            }
            if (i < N - M) {
                t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + M)) % q;
                if (t < 0) t += q;
            }
        }
    }

    public static void main(String[] args) {
        search("abc", "abdabcbabc");
    }
}

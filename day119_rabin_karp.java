// Rabin-Karp string search (rolling hash)
public class day119_rabin_karp {

    static final long MOD = 1_000_000_007L;
    static final long BASE = 256L;

    static void search(String txt, String pat) {
        int n = txt.length(), m = pat.length();
        if (m > n) { System.out.println("No occurrences"); return; }

        long patHash = 0, txtHash = 0, h = 1;
        for (int i = 0; i < m - 1; i++) h = (h * BASE) % MOD;
        for (int i = 0; i < m; i++) {
            patHash = (patHash * BASE + pat.charAt(i)) % MOD;
            txtHash = (txtHash * BASE + txt.charAt(i)) % MOD;
        }

        for (int i = 0; i <= n - m; i++) {
            if (patHash == txtHash) {
                if (txt.substring(i, i + m).equals(pat))
                    System.out.println("Pattern found at index " + i);
            }
            if (i < n - m) {
                txtHash = ( (txtHash - txt.charAt(i) * h) % MOD + MOD ) % MOD;
                txtHash = (txtHash * BASE + txt.charAt(i + m)) % MOD;
            }
        }
    }

    public static void main(String[] args) {
        String txt = "GEEKS FOR GEEKS";
        String pat = "GEEK";
        search(txt, pat);
    }
}

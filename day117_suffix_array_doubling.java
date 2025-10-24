import java.util.*;
/*
 Doubling method suffix array (O(n log n)) with LCP construction (Kasai).
*/
public class day117_suffix_array_doubling {
    static int[] buildSA(String s) {
        int n = s.length();
        int[] sa = new int[n], ranks = new int[n], tmp = new int[n];
        for (int i = 0; i < n; i++) { sa[i] = i; ranks[i] = s.charAt(i); }

        for (int k = 1; k < n; k <<= 1) {
            final int K = k;
            Arrays.sort(sa, (a, b) -> {
                if (ranks[a] != ranks[b]) return Integer.compare(ranks[a], ranks[b]);
                int ra = a + K < n ? ranks[a + K] : -1;
                int rb = b + K < n ? ranks[b + K] : -1;
                return Integer.compare(ra, rb);
            });
            tmp[sa[0]] = 0;
            for (int i = 1; i < n; i++) {
                tmp[sa[i]] = tmp[sa[i - 1]];
                if (ranks[sa[i]] != ranks[sa[i - 1]]
                    || ((sa[i] + K < n ? ranks[sa[i] + K] : -1) != (sa[i - 1] + K < n ? ranks[sa[i - 1] + K] : -1)))
                    tmp[sa[i]]++;
            }
            System.arraycopy(tmp, 0, ranks, 0, n);
            if (ranks[sa[n - 1]] == n - 1) break;
        }
        return sa;
    }

    static int[] buildLCP(String s, int[] sa) {
        int n = s.length();
        int[] rank = new int[n], lcp = new int[n - 1];
        for (int i = 0; i < n; i++) rank[sa[i]] = i;
        int h = 0;
        for (int i = 0; i < n; i++) {
            if (rank[i] > 0) {
                int j = sa[rank[i] - 1];
                while (i + h < n && j + h < n && s.charAt(i + h) == s.charAt(j + h)) h++;
                lcp[rank[i] - 1] = h;
                if (h > 0) h--;
            }
        }
        return lcp;
    }

    public static void main(String[] args) {
        String s = "banana";
        int[] sa = buildSA(s);
        int[] lcp = buildLCP(s, sa);
        System.out.println("SA:");
        for (int idx : sa) System.out.println(idx + ": " + s.substring(idx));
        System.out.println("LCP:");
        for (int x : lcp) System.out.println(x);
    }
}

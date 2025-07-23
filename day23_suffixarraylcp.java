import java.util.*;

public class Day23_SuffixArrayLCP {
    public int[] buildSuffixArray(String s) {
        int n = s.length();
        Integer[] sa = new Integer[n];
        int[] rank = new int[n];
        int[] tmp = new int[n];

        for (int i = 0; i < n; i++) {
            sa[i] = i;
            rank[i] = s.charAt(i);
        }

        for (int k = 1; k < n; k <<= 1) {
            final int K = k;
            Arrays.sort(sa, (i, j) -> {
                if (rank[i] != rank[j])
                    return Integer.compare(rank[i], rank[j]);
                int ri = (i + K < n) ? rank[i + K] : -1;
                int rj = (j + K < n) ? rank[j + K] : -1;
                return Integer.compare(ri, rj);
            });

            tmp[sa[0]] = 0;
            for (int i = 1; i < n; i++) {
                tmp[sa[i]] = tmp[sa[i - 1]] +
                        ((rank[sa[i - 1]] != rank[sa[i]] ||
                          ((sa[i - 1] + K < n ? rank[sa[i - 1] + K] : -1) !=
                           (sa[i] + K < n ? rank[sa[i] + K] : -1))) ? 1 : 0);
            }

            System.arraycopy(tmp, 0, rank, 0, n);
        }

        return Arrays.stream(sa).mapToInt(i -> i).toArray();
    }

    public int[] buildLCP(String s, int[] sa) {
        int n = s.length();
        int[] lcp = new int[n];
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) rank[sa[i]] = i;

        int h = 0;
        for (int i = 0; i < n; i++) {
            if (rank[i] > 0) {
                int j = sa[rank[i] - 1];
                while (i + h < n && j + h < n && s.charAt(i + h) == s.charAt(j + h)) h++;
                lcp[rank[i]] = h;
                if (h > 0) h--;
            }
        }
        return lcp;
    }

    public static void main(String[] args) {
        String s = "banana";
        Day23_SuffixArrayLCP obj = new Day23_SuffixArrayLCP();
        int[] sa = obj.buildSuffixArray(s);
        int[] lcp = obj.buildLCP(s, sa);

        System.out.println("Suffix Array: " + Arrays.toString(sa));
        System.out.println("LCP Array: " + Arrays.toString(lcp));
    }
}

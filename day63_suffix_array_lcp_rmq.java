import java.io.*;
import java.util.*;

/**
 * Suffix Array + Kasai's LCP + RMQ (Sparse Table).
 *
 * Supports:
 *  - Build suffix array O(n log n)
 *  - Build LCP array
 *  - RMQ queries on LCP in O(1) after O(n log n) build
 *  - LCP of any two suffixes in O(1)
 *
 * Input:
 * s
 * q
 * q lines: i j (1-indexed, find LCP of suffix starting at i and j)
 *
 * Output:
 * q lines: LCP length
 */
public class day63_suffix_array_lcp_rmq {
    static int[] buildSA(String s) {
        int n = s.length();
        int[] sa = new int[n], rank = new int[n], tmp = new int[n];
        for (int i = 0; i < n; i++) { sa[i] = i; rank[i] = s.charAt(i); }
        for (int k = 1; k < n; k <<= 1) {
            final int kk = k;
            Arrays.sort(sa, (a, b) -> rank[a] != rank[b] ? rank[a] - rank[b]
                    : ((a + kk < n ? rank[a + kk] : -1) - (b + kk < n ? rank[b + kk] : -1)));
            tmp[sa[0]] = 0;
            for (int i = 1; i < n; i++) {
                tmp[sa[i]] = tmp[sa[i - 1]];
                if (rank[sa[i]] != rank[sa[i - 1]] ||
                        (sa[i] + kk < n ? rank[sa[i] + kk] : -1) != (sa[i - 1] + kk < n ? rank[sa[i - 1] + kk] : -1))
                    tmp[sa[i]]++;
            }
            for (int i = 0; i < n; i++) rank[i] = tmp[i];
            if (rank[sa[n - 1]] == n - 1) break;
        }
        return sa;
    }

    static int[] buildLCP(String s, int[] sa) {
        int n = s.length();
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) rank[sa[i]] = i;
        int[] lcp = new int[n - 1];
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

    static class SparseTable {
        int[][] st;
        int[] log;
        SparseTable(int[] arr) {
            int n = arr.length;
            log = new int[n + 1];
            for (int i = 2; i <= n; i++) log[i] = log[i >> 1] + 1;
            st = new int[log[n] + 1][n];
            System.arraycopy(arr, 0, st[0], 0, n);
            for (int k = 1; (1 << k) <= n; k++)
                for (int i = 0; i + (1 << k) <= n; i++)
                    st[k][i] = Math.min(st[k - 1][i], st[k - 1][i + (1 << (k - 1))]);
        }
        int query(int l, int r) {
            if (l > r) { int tmp = l; l = r; r = tmp; }
            int j = log[r - l + 1];
            return Math.min(st[j][l], st[j][r - (1 << j) + 1]);
        }
    }

    static int lcpQuery(int i, int j, int[] sa, int[] rank, SparseTable st) {
        if (i == j) return sa.length - i;
        int ri = rank[i], rj = rank[j];
        if (ri > rj) { int tmp = ri; ri = rj; rj = tmp; }
        return st.query(ri, rj - 1);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] sa = buildSA(s);
        int[] lcp = buildLCP(s, sa);
        int n = s.length();
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) rank[sa[i]] = i;
        SparseTable st = new SparseTable(lcp);

        int q = Integer.parseInt(br.readLine());
        StringBuilder out = new StringBuilder();
        while (q-- > 0) {
            StringTokenizer tok = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(tok.nextToken()) - 1;
            int j = Integer.parseInt(tok.nextToken()) - 1;
            out.append(lcpQuery(i, j, sa, rank, st)).append('\n');
        }
        System.out.print(out.toString());
    }
}

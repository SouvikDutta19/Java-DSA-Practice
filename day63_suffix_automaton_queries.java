import java.io.*;
import java.util.*;

/**
 * Suffix Automaton (SAM).
 * Features:
 *  - Build SAM for a string s
 *  - Output #distinct substrings
 *  - Answer K pattern occurrence queries (frequency of each pattern in s)
 *  - Output length of the longest repeated substring
 *
 * Input:
 * s
 * k
 * k lines of patterns p_i
 *
 * Output:
 * distinct_substrings
 * longest_repeated_length
 * k lines: occ(p_i)
 */
public class day63_suffix_automaton_queries {
    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        FastScanner(InputStream is) { in = is; }
        private int read() throws IOException {
            if (ptr >= len) { len = in.read(buffer); ptr = 0; if (len <= 0) return -1; }
            return buffer[ptr++];
        }
        String next() throws IOException {
            int c; StringBuilder sb = new StringBuilder();
            do { c = read(); } while (c <= ' ');
            while (c > ' ') { sb.append((char)c); c = read(); }
            return sb.toString();
        }
        int nextInt() throws IOException { return Integer.parseInt(next()); }
    }

    static final int ALPHA = 26;
    static class SAM {
        int[][] next;
        int[] link, len;
        long[] occ; // occurrence counts for endpos
        int last, sz;

        SAM(int maxLen) {
            int maxStates = 2 * maxLen + 5;
            next = new int[maxStates][ALPHA];
            for (int i = 0; i < maxStates; i++) Arrays.fill(next[i], -1);
            link = new int[maxStates];
            len  = new int[maxStates];
            occ  = new long[maxStates];
            last = 0; sz = 1;
            link[0] = -1; len[0] = 0;
        }

        void extend(int c) {
            int cur = sz++;
            len[cur] = len[last] + 1;
            occ[cur] = 1;
            int p = last;
            while (p != -1 && next[p][c] == -1) { next[p][c] = cur; p = link[p]; }
            if (p == -1) link[cur] = 0;
            else {
                int q = next[p][c];
                if (len[p] + 1 == len[q]) link[cur] = q;
                else {
                    int clone = sz++;
                    len[clone] = len[p] + 1;
                    next[clone] = next[q].clone();
                    link[clone] = link[q];
                    occ[clone] = 0; // critical: clone doesn't represent endpos initially
                    while (p != -1 && next[p][c] == q) { next[p][c] = clone; p = link[p]; }
                    link[q] = link[cur] = clone;
                }
            }
            last = cur;
        }

        long distinctSubstrings() {
            long ans = 0;
            for (int v = 1; v < sz; v++) ans += (long)(len[v] - len[link[v]]);
            return ans;
        }

        void buildOcc() {
            // topo order by length
            Integer[] order = new Integer[sz];
            for (int i = 0; i < sz; i++) order[i] = i;
            Arrays.sort(order, Comparator.comparingInt(o -> len[o]));
            for (int i = sz - 1; i > 0; i--) {
                int v = order[i];
                if (link[v] >= 0) occ[link[v]] += occ[v];
            }
        }

        long countOccurrences(String p) {
            int v = 0;
            for (int i = 0; i < p.length(); i++) {
                int c = p.charAt(i) - 'a';
                if (c < 0 || c >= ALPHA) return 0;
                if (next[v][c] == -1) return 0;
                v = next[v][c];
            }
            return occ[v];
        }

        int longestRepeated() {
            // Longest substring that occurs at least twice = max len[v] with occ[v] >= 2
            int best = 0;
            for (int v = 1; v < sz; v++) if (occ[v] >= 2) best = Math.max(best, len[v]);
            return best;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        String s = fs.next();
        SAM sam = new SAM(s.length());
        for (int i = 0; i < s.length(); i++) sam.extend(s.charAt(i) - 'a');
        sam.buildOcc();

        int k = fs.nextInt();
        StringBuilder out = new StringBuilder();
        out.append(sam.distinctSubstrings()).append('\n');
        out.append(sam.longestRepeated()).append('\n');
        for (int i = 0; i < k; i++) {
            String p = fs.next();
            out.append(sam.countOccurrences(p)).append('\n');
        }
        System.out.print(out.toString());
    }
}

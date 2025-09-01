import java.io.*;
import java.util.*;

/**
 * Aho–Corasick automaton for multi-pattern matching (counts occurrences).
 *
 * Input:
 * n
 * n lines: patterns (lowercase a-z)
 * text
 *
 * Output:
 * n lines: count of occurrences of pattern i in the text
 *
 * Handles overlapping matches. Uses BFS to build failure links and propagate counts.
 */
public class day63_aho_corasick_count {
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

    static class Node {
        int[] nxt = new int[ALPHA];
        int link = 0;
        List<Integer> out = new ArrayList<>(); // pattern indices ending here
        Node() { Arrays.fill(nxt, -1); }
    }

    static List<Node> trie = new ArrayList<>();
    static { trie.add(new Node()); } // root

    static void addPattern(String s, int id) {
        int v = 0;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (trie.get(v).nxt[c] == -1) {
                trie.get(v).nxt[c] = trie.size();
                trie.add(new Node());
            }
            v = trie.get(v).nxt[c];
        }
        trie.get(v).out.add(id);
    }

    static void buildLinks() {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int c = 0; c < ALPHA; c++) {
            int to = trie.get(0).nxt[c];
            if (to != -1) { trie.get(to).link = 0; q.add(to); }
            else trie.get(0).nxt[c] = 0;
        }
        while (!q.isEmpty()) {
            int v = q.poll();
            for (int c = 0; c < ALPHA; c++) {
                int to = trie.get(v).nxt[c];
                if (to != -1) {
                    trie.get(to).link = trie.get(trie.get(v).link).nxt[c];
                    trie.get(to).out.addAll(trie.get(trie.get(to).link).out);
                    q.add(to);
                } else {
                    trie.get(v).nxt[c] = trie.get(trie.get(v).link).nxt[c];
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();
        String[] pats = new String[n];
        for (int i = 0; i < n; i++) { pats[i] = fs.next(); addPattern(pats[i], i); }
        buildLinks();
        String text = fs.next();

        long[] ans = new long[n];
        int v = 0;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            int c = ch - 'a';
            if (c < 0 || c >= ALPHA) { v = 0; continue; }
            v = trie.get(v).nxt[c];
            for (int id : trie.get(v).out) ans[id]++;
        }
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < n; i++) out.append(ans[i]).append('\n');
        System.out.print(out.toString());
    }
}

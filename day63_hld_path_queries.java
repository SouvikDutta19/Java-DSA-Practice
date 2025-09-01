import java.io.*;
import java.util.*;

/**
 * Heavy-Light Decomposition (HLD) with iterative Segment Tree.
 * Supports:
 *  - Type 1 u v : query path sum from u to v (inclusive)
 *  - Type 2 u x : point update: set value at node u to x
 *
 * Input format:
 * n
 * a1 a2 ... an              (1-indexed node values)
 * n-1 lines: u v            (tree edges)
 * q
 * q lines of queries in either forms above
 *
 * Example:
 * 5
 * 1 2 3 4 5
 * 1 2
 * 1 3
 * 3 4
 * 3 5
 * 5
 * 1 2 4
 * 2 3 10
 * 1 2 4
 * 1 4 5
 * 2 5 0
 *
 * Output:
 * (one answer per type 1 query)
 */
public class day63_hld_path_queries {
    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        FastScanner(InputStream is) { in = is; }
        private int read() throws IOException {
            if (ptr >= len) { len = in.read(buffer); ptr = 0; if (len <= 0) return -1; }
            return buffer[ptr++];
        }
        int nextInt() throws IOException {
            int c, s = 1, x = 0;
            do { c = read(); } while (c <= ' ');
            if (c == '-') { s = -1; c = read(); }
            while (c > ' ') { x = x * 10 + (c - '0'); c = read(); }
            return x * s;
        }
    }

    static int N, LOG;
    static List<Integer>[] g;
    static int[] parent, depth, heavy, head, pos, sz;
    static long[] base;       // values in the order of pos[]
    static int curPos = 0;

    // Iterative segment tree for sums
    static class SegTree {
        int n;
        long[] t;
        SegTree(int n) {
            this.n = 1;
            while (this.n < n) this.n <<= 1;
            t = new long[this.n << 1];
        }
        void build(long[] a) {
            for (int i = 0; i < a.length; i++) t[i + n] = a[i];
            for (int i = n - 1; i > 0; i--) t[i] = t[i << 1] + t[i << 1 | 1];
        }
        void pointSet(int idx, long val) { // set a[idx] = val
            int p = idx + n;
            t[p] = val;
            for (p >>= 1; p > 0; p >>= 1) t[p] = t[p << 1] + t[p << 1 | 1];
        }
        long rangeSum(int l, int r) { // inclusive l..r
            long res = 0;
            for (l += n, r += n; l <= r; l >>= 1, r >>= 1) {
                if ((l & 1) == 1) res += t[l++];
                if ((r & 1) == 0) res += t[r--];
            }
            return res;
        }
    }

    static int dfs1(int v, int p) {
        parent[v] = p;
        depth[v] = (p == -1) ? 0 : depth[p] + 1;
        int size = 1, maxSub = 0;
        for (int to : g[v]) if (to != p) {
            int sub = dfs1(to, v);
            if (sub > maxSub) { maxSub = sub; heavy[v] = to; }
            size += sub;
        }
        sz[v] = size;
        return size;
    }

    static void dfs2(int v, int h, long[] val) {
        head[v] = h;
        pos[v] = curPos;
        base[curPos++] = val[v];
        if (heavy[v] != -1) dfs2(heavy[v], h, val);
        for (int to : g[v]) if (to != parent[v] && to != heavy[v]) dfs2(to, to, val);
    }

    static long queryPath(int a, int b, SegTree st) {
        long res = 0;
        while (head[a] != head[b]) {
            if (depth[head[a]] < depth[head[b]]) { int tmp = a; a = b; b = tmp; }
            int h = head[a];
            res += st.rangeSum(pos[h], pos[a]);
            a = parent[h];
        }
        if (depth[a] > depth[b]) { int tmp = a; a = b; b = tmp; }
        res += st.rangeSum(pos[a], pos[b]);
        return res;
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        int n = N = fs.nextInt();
        long[] val = new long[n + 1];
        for (int i = 1; i <= n; i++) val[i] = fs.nextInt();

        g = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) g[i] = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            int u = fs.nextInt(), v = fs.nextInt();
            g[u].add(v); g[v].add(u);
        }

        parent = new int[n + 1];
        depth  = new int[n + 1];
        heavy  = new int[n + 1];
        head   = new int[n + 1];
        pos    = new int[n + 1];
        sz     = new int[n + 1];
        Arrays.fill(heavy, -1);

        dfs1(1, -1);
        base = new long[n];
        dfs2(1, 1, val);

        SegTree st = new SegTree(n);
        st.build(base);

        int q = fs.nextInt();
        StringBuilder out = new StringBuilder();
        while (q-- > 0) {
            int t = fs.nextInt();
            if (t == 1) {
                int u = fs.nextInt(), v = fs.nextInt();
                out.append(queryPath(u, v, st)).append('\n');
            } else {
                int u = fs.nextInt(); long x = fs.nextInt();
                st.pointSet(pos[u], x);
            }
        }
        System.out.print(out.toString());
    }
}

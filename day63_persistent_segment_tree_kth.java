import java.io.*;
import java.util.*;

/**
 * Persistent Segment Tree (Chairman Tree) for K-th smallest in subarray [l, r].
 *
 * Input:
 * n q
 * a1 a2 ... an
 * q lines: l r k   (1-indexed, find k-th smallest in a[l..r])
 *
 * Output:
 * q lines: answer
 *
 * Implementation details:
 *  - Coordinate compression of values
 *  - Build prefix version roots[0..n]
 *  - Query using two versions: root[r] and root[l-1]
 */
public class day63_persistent_segment_tree_kth {
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

    static class Node {
        int l, r, sum;
        Node() {}
        Node(int l, int r, int sum) { this.l = l; this.r = r; this.sum = sum; }
    }

    static final int MAXN = 200000 * 25; // safe upper bound for n up to 2e5
    static Node[] pool = new Node[MAXN];
    static int ptr = 0;

    static int newNode(int l, int r, int sum) {
        pool[ptr] = new Node(l, r, sum);
        return ptr++;
    }

    static int build(int tl, int tr) {
        int v = newNode(-1, -1, 0);
        if (tl != tr) {
            int tm = (tl + tr) >>> 1;
            pool[v].l = build(tl, tm);
            pool[v].r = build(tm + 1, tr);
        }
        return v;
    }

    static int update(int prev, int tl, int tr, int pos) {
        int v = newNode(pool[prev].l, pool[prev].r, pool[prev].sum + 1);
        if (tl != tr) {
            int tm = (tl + tr) >>> 1;
            if (pos <= tm) {
                int nl = update(pool[prev].l, tl, tm, pos);
                pool[v].l = nl;
            } else {
                int nr = update(pool[prev].r, tm + 1, tr, pos);
                pool[v].r = nr;
            }
        }
        return v;
    }

    static int kth(int vr, int vl, int tl, int tr, int k) {
        if (tl == tr) return tl;
        int leftCount = pool[pool[vr].l].sum - pool[pool[vl].l].sum;
        int tm = (tl + tr) >>> 1;
        if (k <= leftCount) return kth(pool[vr].l, pool[vl].l, tl, tm, k);
        else return kth(pool[vr].r, pool[vl].r, tm + 1, tr, k - leftCount);
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt(), q = fs.nextInt();
        int[] a = new int[n + 1];
        int[] vals = new int[n];
        for (int i = 1; i <= n; i++) { a[i] = fs.nextInt(); vals[i - 1] = a[i]; }
        int[] comp = vals.clone();
        Arrays.sort(comp);
        comp = Arrays.stream(comp).distinct().toArray();
        int m = comp.length;

        int[] A = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int x = Arrays.binarySearch(comp, a[i]);
            A[i] = x + 1; // 1..m
        }

        int[] root = new int[n + 1];
        root[0] = build(1, m);
        for (int i = 1; i <= n; i++) root[i] = update(root[i - 1], 1, m, A[i]);

        StringBuilder out = new StringBuilder();
        while (q-- > 0) {
            int l = fs.nextInt(), r = fs.nextInt(), k = fs.nextInt();
            int idx = kth(root[r], root[l - 1], 1, m, k);
            out.append(comp[idx - 1]).append('\n');
        }
        System.out.print(out.toString());
    }
}

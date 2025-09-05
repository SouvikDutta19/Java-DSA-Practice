import java.io.*;
import java.util.*;

/**
 * Implicit Treap supporting:
 *  - range reverse
 *  - range add
 *  - range sum query
 *
 * Input:
 * n
 * a1 a2 ... an
 * q
 * q lines of operations:
 *   1 l r           -> reverse [l, r] (1-indexed)
 *   2 l r x         -> add x to [l, r]
 *   3 l r           -> query sum of [l, r]
 */
public class day67_implicit_treap_range_reverse {
    static class Node {
        int pr, sz;
        long val, sum, add;
        boolean rev;
        Node l, r;
        Node(long v) { val = v; sum = v; pr = RNG.nextInt(); sz = 1; }
    }
    static final Random RNG = new Random(712367);
    static int sz(Node t) { return t == null ? 0 : t.sz; }
    static long sum(Node t) { return t == null ? 0 : t.sum; }

    static void push(Node t) {
        if (t == null) return;
        if (t.rev) {
            Node tmp = t.l; t.l = t.r; t.r = tmp;
            if (t.l != null) t.l.rev ^= true;
            if (t.r != null) t.r.rev ^= true;
            t.rev = false;
        }
        if (t.add != 0) {
            if (t.l != null) { t.l.add += t.add; t.l.val += t.add; t.l.sum += (long)sz(t.l) * t.add; }
            if (t.r != null) { t.r.add += t.add; t.r.val += t.add; t.r.sum += (long)sz(t.r) * t.add; }
            t.add = 0;
        }
    }
    static void pull(Node t) {
        if (t == null) return;
        t.sz = 1 + sz(t.l) + sz(t.r);
        t.sum = t.val + sum(t.l) + sum(t.r);
    }

    static void split(Node t, int k, Node[] res) { // left size = k
        if (t == null) { res[0] = res[1] = null; return; }
        push(t);
        if (sz(t.l) >= k) {
            split(t.l, k, res);
            t.l = res[1];
            pull(t);
            res[1] = t;
        } else {
            split(t.r, k - sz(t.l) - 1, res);
            t.r = res[0];
            pull(t);
            res[0] = t;
        }
    }
    static Node merge(Node a, Node b) {
        if (a == null) return b;
        if (b == null) return a;
        if (a.pr > b.pr) {
            push(a);
            a.r = merge(a.r, b);
            pull(a);
            return a;
        } else {
            push(b);
            b.l = merge(a, b.l);
            pull(b);
            return b;
        }
    }

    static void rangeReverse(Node[] root, int l, int r) {
        Node[] p = new Node[2]; Node[] q = new Node[2];
        split(root[0], r, p);       // [0..r] | [r+1..]
        split(p[0], l - 1, q);      // [0..l-1] | [l..r]
        if (q[1] != null) q[1].rev ^= true;
        root[0] = merge(merge(q[0], q[1]), p[1]);
    }
    static void rangeAdd(Node[] root, int l, int r, long x) {
        Node[] p = new Node[2]; Node[] q = new Node[2];
        split(root[0], r, p);
        split(p[0], l - 1, q);
        if (q[1] != null) {
            q[1].add += x;
            q[1].val += x;
            q[1].sum += (long)sz(q[1]) * x;
        }
        root[0] = merge(merge(q[0], q[1]), p[1]);
    }
    static long rangeSum(Node[] root, int l, int r) {
        Node[] p = new Node[2]; Node[] q = new Node[2];
        split(root[0], r, p);
        split(p[0], l - 1, q);
        long ans = sum(q[1]);
        root[0] = merge(merge(q[0], q[1]), p[1]);
        return ans;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Node root = null;
        for (int i = 0; i < n; i++) root = merge(root, new Node(Long.parseLong(st.nextToken())));
        Node[] R = new Node[]{root};

        int q = Integer.parseInt(br.readLine().trim());
        StringBuilder out = new StringBuilder();
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            if (t == 1) {
                int l = Integer.parseInt(st.nextToken()), r = Integer.parseInt(st.nextToken());
                rangeReverse(R, l, r);
            } else if (t == 2) {
                int l = Integer.parseInt(st.nextToken()), r = Integer.parseInt(st.nextToken());
                long x = Long.parseLong(st.nextToken());
                rangeAdd(R, l, r, x);
            } else {
                int l = Integer.parseInt(st.nextToken()), r = Integer.parseInt(st.nextToken());
                out.append(rangeSum(R, l, r)).append('\n');
            }
        }
        System.out.print(out.toString());
    }
}

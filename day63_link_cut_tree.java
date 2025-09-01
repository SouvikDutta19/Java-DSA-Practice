import java.io.*;
import java.util.*;

/**
 * Link-Cut Tree (Splay-based) for dynamic tree operations.
 *
 * Supports:
 *  - link(u, v): connect u as child of v
 *  - cut(u): cut edge between u and its parent
 *  - findRoot(u): return root of the tree containing u
 *  - pathSum(u, v): sum of node values along path u–v
 *
 * Input format:
 * n q
 * values[1..n]
 * q lines of queries:
 *   1 u v   -> link(u, v)
 *   2 u     -> cut(u)
 *   3 u v   -> pathSum(u, v)
 *   4 u     -> findRoot(u)
 *
 * Example:
 * 5 6
 * 1 2 3 4 5
 * 1 1 2
 * 1 2 3
 * 3 1 3
 * 2 2
 * 1 4 5
 * 3 4 5
 */
public class day63_link_cut_tree {
    static class Node {
        Node left, right, parent;
        boolean rev;
        long val, sum;

        Node(long v) { val = sum = v; }

        void push() {
            if (rev) {
                Node t = left; left = right; right = t;
                if (left != null) left.rev ^= true;
                if (right != null) right.rev ^= true;
                rev = false;
            }
        }

        void pull() {
            sum = val + (left != null ? left.sum : 0) + (right != null ? right.sum : 0);
        }
    }

    static boolean isRoot(Node x) {
        return x.parent == null || (x.parent.left != x && x.parent.right != x);
    }

    static void rotate(Node x) {
        Node p = x.parent, g = p.parent;
        if (!isRoot(p)) { if (g.left == p) g.left = x; else g.right = x; }
        if (p.left == x) {
            p.left = x.right; if (x.right != null) x.right.parent = p;
            x.right = p;
        } else {
            p.right = x.left; if (x.left != null) x.left.parent = p;
            x.left = p;
        }
        p.parent = x; x.parent = g;
        p.pull(); x.pull();
    }

    static void splay(Node x) {
        Deque<Node> st = new ArrayDeque<>();
        Node y = x;
        while (!isRoot(y)) { st.push(y); y = y.parent; }
        st.push(y);
        while (!st.isEmpty()) st.pop().push();
        while (!isRoot(x)) {
            Node p = x.parent, g = p.parent;
            if (!isRoot(p)) {
                if ((g.left == p) == (p.left == x)) rotate(p);
                else rotate(x);
            }
            rotate(x);
        }
    }

    static void access(Node x) {
        Node last = null;
        for (Node y = x; y != null; y = y.parent) {
            splay(y);
            y.right = last;
            y.pull();
            last = y;
        }
        splay(x);
    }

    static void makeRoot(Node x) {
        access(x);
        x.rev ^= true;
        x.push();
    }

    static Node findRoot(Node x) {
        access(x);
        while (x.left != null) { x.push(); x = x.left; }
        splay(x);
        return x;
    }

    static void link(Node u, Node v) {
        makeRoot(u);
        if (findRoot(v) != u) u.parent = v;
    }

    static void cut(Node u) {
        access(u);
        if (u.left != null) {
            u.left.parent = null;
            u.left = null;
            u.pull();
        }
    }

    static long pathSum(Node u, Node v) {
        makeRoot(u);
        access(v);
        return v.sum;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), q = Integer.parseInt(st.nextToken());
        Node[] nodes = new Node[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) nodes[i] = new Node(Long.parseLong(st.nextToken()));

        StringBuilder out = new StringBuilder();
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            if (t == 1) {
                int u = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken());
                link(nodes[u], nodes[v]);
            } else if (t == 2) {
                int u = Integer.parseInt(st.nextToken());
                cut(nodes[u]);
            } else if (t == 3) {
                int u = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken());
                out.append(pathSum(nodes[u], nodes[v])).append('\n');
            } else {
                int u = Integer.parseInt(st.nextToken());
                out.append(findRoot(nodes[u]) == nodes[u] ? u : "root=").append('\n');
            }
        }
        System.out.print(out.toString());
    }
}

import java.io.*;
import java.util.*;

/**
 * Dinic's Maximum Flow with Min-Cut extraction.
 *
 * Input:
 * n m s t
 * m lines: u v c  (directed edge capacity c >= 0)
 *
 * Output:
 * maxflow
 * k                           (# of edges in a minimum s-t cut)
 * k lines: u v                (edges from reachable to non-reachable in residual)
 *
 * Notes:
 *  - Uses long capacities
 *  - O(m * n^(2/3)) usually fast in practice
 */
public class day63_dinic_maxflow_mincut {
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
        long nextLong() throws IOException { return Long.parseLong(nextToken()); }
        String nextToken() throws IOException {
            int c; StringBuilder sb = new StringBuilder();
            do { c = read(); } while (c <= ' ');
            while (c > ' ') { sb.append((char)c); c = read(); }
            return sb.toString();
        }
    }

    static class Edge {
        int to, rev;
        long cap;
        Edge(int to, int rev, long cap) { this.to = to; this.rev = rev; this.cap = cap; }
    }

    static class Dinic {
        int n, s, t;
        List<Edge>[] g;
        int[] level, it;

        @SuppressWarnings("unchecked")
        Dinic(int n, int s, int t) {
            this.n = n; this.s = s; this.t = t;
            g = new ArrayList[n];
            for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
            level = new int[n];
            it = new int[n];
        }

        void addEdge(int u, int v, long c) {
            Edge a = new Edge(v, g[v].size(), c);
            Edge b = new Edge(u, g[u].size(), 0);
            g[u].add(a); g[v].add(b);
        }

        boolean bfs() {
            Arrays.fill(level, -1);
            ArrayDeque<Integer> dq = new ArrayDeque<>();
            level[s] = 0; dq.add(s);
            while (!dq.isEmpty()) {
                int u = dq.poll();
                for (Edge e : g[u]) if (e.cap > 0 && level[e.to] < 0) {
                    level[e.to] = level[u] + 1;
                    dq.add(e.to);
                }
            }
            return level[t] >= 0;
        }

        long dfs(int u, long f) {
            if (u == t) return f;
            for (int i = it[u]; i < g[u].size(); i = ++it[u]) {
                Edge e = g[u].get(i);
                if (e.cap > 0 && level[e.to] == level[u] + 1) {
                    long ret = dfs(e.to, Math.min(f, e.cap));
                    if (ret > 0) {
                        e.cap -= ret;
                        g[e.to].get(e.rev).cap += ret;
                        return ret;
                    }
                }
            }
            return 0;
        }

        long maxflow() {
            long flow = 0, INF = Long.MAX_VALUE / 4;
            while (bfs()) {
                Arrays.fill(it, 0);
                long pushed;
                while ((pushed = dfs(s, INF)) > 0) flow += pushed;
            }
            return flow;
        }

        boolean[] minCutReachable() {
            // After maxflow, run BFS from s on residual graph to mark reachable
            boolean[] vis = new boolean[n];
            ArrayDeque<Integer> dq = new ArrayDeque<>();
            dq.add(s); vis[s] = true;
            while (!dq.isEmpty()) {
                int u = dq.poll();
                for (Edge e : g[u]) if (e.cap > 0 && !vis[e.to]) {
                    vis[e.to] = true; dq.add(e.to);
                }
            }
            return vis;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt(), m = fs.nextInt(), s = fs.nextInt() - 1, t = fs.nextInt() - 1;
        Dinic d = new Dinic(n, s, t);
        int[] U = new int[m], V = new int[m];
        for (int i = 0; i < m; i++) {
            int u = fs.nextInt() - 1, v = fs.nextInt() - 1;
            long c = fs.nextLong();
            d.addEdge(u, v, c);
            U[i] = u; V[i] = v;
        }
        long flow = d.maxflow();
        boolean[] reach = d.minCutReachable();

        // Collect edges crossing min cut in the original direction
        List<int[]> cut = new ArrayList<>();
        for (int u = 0; u < n; u++) {
            for (Edge e : d.g[u]) {
                if (e.cap == 0) continue; // only residual capacity edges; for extraction, better scan original edges
            }
        }
        // safer: re-scan original edge list U,V and check reachability split
        for (int i = 0; i < m; i++) if (reach[U[i]] && !reach[V[i]]) cut.add(new int[]{U[i] + 1, V[i] + 1});

        StringBuilder out = new StringBuilder();
        out.append(flow).append('\n');
        out.append(cut.size()).append('\n');
        for (int[] e : cut) out.append(e[0]).append(' ').append(e[1]).append('\n');
        System.out.print(out.toString());
    }
}

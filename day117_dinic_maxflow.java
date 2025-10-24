import java.util.*;
// Dinic's algorithm for maximum flow (efficient)
public class day117_dinic_maxflow {
    static class Edge {
        int to, rev;
        int cap;
        Edge(int to, int rev, int cap) { this.to = to; this.rev = rev; this.cap = cap; }
    }

    int N;
    List<Edge>[] G;
    int[] level, it;

    @SuppressWarnings("unchecked")
    public day117_dinic_maxflow(int n) {
        N = n;
        G = new List[N];
        for (int i = 0; i < N; i++) G[i] = new ArrayList<>();
        level = new int[N];
        it = new int[N];
    }

    void addEdge(int u, int v, int cap) {
        G[u].add(new Edge(v, G[v].size(), cap));
        G[v].add(new Edge(u, G[u].size() - 1, 0));
    }

    boolean bfs(int s, int t) {
        Arrays.fill(level, -1);
        Queue<Integer> q = new ArrayDeque<>();
        level[s] = 0; q.add(s);
        while (!q.isEmpty()) {
            int v = q.poll();
            for (Edge e : G[v]) {
                if (e.cap > 0 && level[e.to] < 0) {
                    level[e.to] = level[v] + 1;
                    q.add(e.to);
                }
            }
        }
        return level[t] >= 0;
    }

    int dfs(int v, int t, int f) {
        if (v == t) return f;
        for (int i = it[v]; i < G[v].size(); i++, it[v]++) {
            Edge e = G[v].get(i);
            if (e.cap > 0 && level[e.to] == level[v] + 1) {
                int ret = dfs(e.to, t, Math.min(f, e.cap));
                if (ret > 0) {
                    e.cap -= ret;
                    G[e.to].get(e.rev).cap += ret;
                    return ret;
                }
            }
        }
        return 0;
    }

    int maxFlow(int s, int t) {
        int flow = 0, inf = Integer.MAX_VALUE;
        while (bfs(s, t)) {
            Arrays.fill(it, 0);
            int f;
            while ((f = dfs(s, t, inf)) > 0) flow += f;
        }
        return flow;
    }

    public static void main(String[] args) {
        day117_dinic_maxflow dinic = new day117_dinic_maxflow(6);
        dinic.addEdge(0, 1, 16);
        dinic.addEdge(0, 2, 13);
        dinic.addEdge(1, 2, 10);
        dinic.addEdge(1, 3, 12);
        dinic.addEdge(2, 1, 4);
        dinic.addEdge(2, 4, 14);
        dinic.addEdge(3, 2, 9);
        dinic.addEdge(3, 5, 20);
        dinic.addEdge(4, 3, 7);
        dinic.addEdge(4, 5, 4);
        System.out.println("Max Flow = " + dinic.maxFlow(0,5));
    }
}

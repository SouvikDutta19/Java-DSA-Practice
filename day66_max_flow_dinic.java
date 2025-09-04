import java.io.*;
import java.util.*;

public class day66_max_flow_dinic {
    static class Edge {
        int v, rev, cap;
        Edge(int v, int rev, int cap) { this.v = v; this.rev = rev; this.cap = cap; }
    }

    static List<List<Edge>> adj;
    static int[] level, it;

    static void addEdge(int u, int v, int cap) {
        adj.get(u).add(new Edge(v, adj.get(v).size(), cap));
        adj.get(v).add(new Edge(u, adj.get(u).size()-1, 0));
    }

    static boolean bfs(int s, int t) {
        Arrays.fill(level, -1); level[s] = 0;
        Queue<Integer> q = new LinkedList<>(); q.add(s);
        while (!q.isEmpty()) {
            int u = q.poll();
            for (Edge e : adj.get(u)) {
                if (level[e.v] < 0 && e.cap > 0) {
                    level[e.v] = level[u] + 1;
                    q.add(e.v);
                }
            }
        }
        return level[t] >= 0;
    }

    static int dfs(int u, int t, int flow) {
        if (u == t) return flow;
        for (; it[u] < adj.get(u).size(); it[u]++) {
            Edge e = adj.get(u).get(it[u]);
            if (e.cap > 0 && level[e.v] == level[u] + 1) {
                int f = dfs(e.v, t, Math.min(flow, e.cap));
                if (f > 0) {
                    e.cap -= f;
                    adj.get(e.v).get(e.rev).cap += f;
                    return f;
                }
            }
        }
        return 0;
    }

    static int dinic(int s, int t) {
        int maxFlow = 0;
        while (bfs(s, t)) {
            Arrays.fill(it, 0);
            int flow;
            while ((flow = dfs(s, t, Integer.MAX_VALUE)) > 0) maxFlow += flow;
        }
        return maxFlow;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        adj = new ArrayList<>(); for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
            addEdge(u, v, c);
        }
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken()), t = Integer.parseInt(st.nextToken());
        level = new int[n]; it = new int[n];
        System.out.println(dinic(s, t));
    }
}

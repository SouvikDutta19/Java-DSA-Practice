import java.util.*;

public class day21_bridgeedges {
    static class Graph {
        int V, time;
        List<Integer>[] adj;
        boolean[] visited;
        int[] disc, low, parent;

        Graph(int V) {
            this.V = V;
            adj = new ArrayList[V];
            for (int i = 0; i < V; i++) adj[i] = new ArrayList<>();
            visited = new boolean[V];
            disc = new int[V];
            low = new int[V];
            parent = new int[V];
            Arrays.fill(parent, -1);
            time = 0;
        }

        void addEdge(int u, int v) {
            adj[u].add(v);
            adj[v].add(u);
        }

        void dfs(int u) {
            visited[u] = true;
            disc[u] = low[u] = ++time;

            for (int v : adj[u]) {
                if (!visited[v]) {
                    parent[v] = u;
                    dfs(v);
                    low[u] = Math.min(low[u], low[v]);

                    if (low[v] > disc[u])
                        System.out.println("Bridge: " + u + " - " + v);
                } else if (v != parent[u]) {
                    low[u] = Math.min(low[u], disc[v]);
                }
            }
        }

        void findBridges() {
            for (int i = 0; i < V; i++) {
                if (!visited[i])
                    dfs(i);
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);

        g.findBridges();
    }
}

import java.util.*;

public class day21_articulationpoints {
    static class Graph {
        int V, time;
        List<Integer>[] adj;
        boolean[] visited, isArticulation;
        int[] disc, low, parent;

        Graph(int V) {
            this.V = V;
            adj = new ArrayList[V];
            for (int i = 0; i < V; i++) adj[i] = new ArrayList<>();
            visited = new boolean[V];
            isArticulation = new boolean[V];
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
            int children = 0;

            for (int v : adj[u]) {
                if (!visited[v]) {
                    children++;
                    parent[v] = u;
                    dfs(v);
                    low[u] = Math.min(low[u], low[v]);

                    if (parent[u] == -1 && children > 1)
                        isArticulation[u] = true;

                    if (parent[u] != -1 && low[v] >= disc[u])
                        isArticulation[u] = true;
                } else if (v != parent[u]) {
                    low[u] = Math.min(low[u], disc[v]);
                }
            }
        }

        void findArticulationPoints() {
            for (int i = 0; i < V; i++) {
                if (!visited[i])
                    dfs(i);
            }

            System.out.print("Articulation Points: ");
            for (int i = 0; i < V; i++) {
                if (isArticulation[i])
                    System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(7);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(5, 6);

        g.findArticulationPoints();
    }
}

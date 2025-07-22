// Program to find articulation points (cut vertices) in an undirected graph using DFS

import java.util.*;

public class day22_articulation_point_finder {
    static class Graph {
        int V;
        List<Integer>[] adj;
        int time = 0;

        Graph(int V) {
            this.V = V;
            adj = new ArrayList[V];
            for (int i = 0; i < V; i++)
                adj[i] = new ArrayList<>();
        }

        void addEdge(int u, int v) {
            adj[u].add(v);
            adj[v].add(u);
        }

        void findArticulationPoints() {
            boolean[] visited = new boolean[V];
            int[] disc = new int[V];
            int[] low = new int[V];
            int[] parent = new int[V];
            boolean[] ap = new boolean[V];

            Arrays.fill(parent, -1);

            for (int i = 0; i < V; i++) {
                if (!visited[i])
                    dfs(i, visited, disc, low, parent, ap);
            }

            System.out.println("Articulation Points:");
            for (int i = 0; i < V; i++) {
                if (ap[i])
                    System.out.print(i + " ");
            }
        }

        void dfs(int u, boolean[] visited, int[] disc, int[] low, int[] parent, boolean[] ap) {
            int children = 0;
            visited[u] = true;

            disc[u] = low[u] = ++time;

            for (int v : adj[u]) {
                if (!visited[v]) {
                    children++;
                    parent[v] = u;
                    dfs(v, visited, disc, low, parent, ap);

                    low[u] = Math.min(low[u], low[v]);

                    if (parent[u] == -1 && children > 1)
                        ap[u] = true;

                    if (parent[u] != -1 && low[v] >= disc[u])
                        ap[u] = true;
                } else if (v != parent[u]) {
                    low[u] = Math.min(low[u], disc[v]);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.findArticulationPoints();
    }
}

import java.util.*;

// Edmonds-Karp implementation of Ford-Fulkerson (BFS for augmenting paths)
public class day106_fordfulkerson {
    private static boolean bfs(int[][] rGraph, int s, int t, int[] parent) {
        int V = rGraph.length;
        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);
        Queue<Integer> q = new LinkedList<>();
        q.add(s); visited[s] = true; parent[s] = -1;

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v = 0; v < V; v++) {
                if (!visited[v] && rGraph[u][v] > 0) {
                    q.add(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }
        return visited[t];
    }

    public static int fordFulkerson(int[][] graph, int s, int t) {
        int u, v;
        int V = graph.length;
        int[][] rGraph = new int[V][V];
        for (u = 0; u < V; u++)
            rGraph[u] = Arrays.copyOf(graph[u], V);

        int[] parent = new int[V];
        int maxFlow = 0;

        while (bfs(rGraph, s, t, parent)) {
            int pathFlow = Integer.MAX_VALUE;
            for (v = t; v != s; v = parent[v]) {
                u = parent[v];
                pathFlow = Math.min(pathFlow, rGraph[u][v]);
            }
            for (v = t; v != s; v = parent[v]) {
                u = parent[v];
                rGraph[u][v] -= pathFlow;
                rGraph[v][u] += pathFlow;
            }
            maxFlow += pathFlow;
        }
        return maxFlow;
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 16, 13, 0, 0, 0},
            {0, 0, 10, 12, 0, 0},
            {0, 4, 0, 0, 14, 0},
            {0, 0, 9, 0, 0, 20},
            {0, 0, 0, 7, 0, 4},
            {0, 0, 0, 0, 0, 0}
        };
        System.out.println("Max Flow: " + fordFulkerson(graph, 0, 5));
    }
}

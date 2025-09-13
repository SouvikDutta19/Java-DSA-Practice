import java.util.*;

public class day74_edmonds_karp {
    static final int V = 6;

    static boolean bfs(int[][] rGraph, int s, int t, int[] parent) {
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s] = true;
        parent[s] = -1;

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

    static int edmondsKarp(int[][] graph, int s, int t) {
        int u, v;
        int[][] rGraph = new int[V][V];
        for (u = 0; u < V; u++) for (v = 0; v < V; v++) rGraph[u][v] = graph[u][v];
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
            {0,16,13,0,0,0},
            {0,0,10,12,0,0},
            {0,4,0,0,14,0},
            {0,0,9,0,0,20},
            {0,0,0,7,0,4},
            {0,0,0,0,0,0}
        };
        System.out.println("Max Flow: " + edmondsKarp(graph,0,5));
    }
}

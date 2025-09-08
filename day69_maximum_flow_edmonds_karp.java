import java.util.*;

public class day69_maximum_flow_edmonds_karp {
    static int bfs(int[][] rGraph, int s, int t, int[] parent) {
        Arrays.fill(parent, -1);
        parent[s] = s;
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v = 0; v < rGraph.length; v++) {
                if (parent[v] == -1 && rGraph[u][v] > 0) {
                    parent[v] = u;
                    if (v == t) return 1;
                    q.add(v);
                }
            }
        }
        return 0;
    }

    static int maxFlow(int[][] graph, int s, int t) {
        int n = graph.length;
        int[][] rGraph = new int[n][n];
        for (int i = 0; i < n; i++) rGraph[i] = Arrays.copyOf(graph[i], n);
        int[] parent = new int[n];
        int maxFlow = 0;
        while (bfs(rGraph, s, t, parent) == 1) {
            int pathFlow = Integer.MAX_VALUE;
            for (int v = t; v != s; v = parent[v]) {
                int u = parent[v];
                pathFlow = Math.min(pathFlow, rGraph[u][v]);
            }
            for (int v = t; v != s; v = parent[v]) {
                int u = parent[v];
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
        System.out.println("Max Flow: " + maxFlow(graph,0,5));
    }
}

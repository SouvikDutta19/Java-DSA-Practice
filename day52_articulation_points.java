import java.util.*;

public class day52_articulation_points {
    static int time = 0;

    public static void dfs(int u, boolean[] visited, int[] disc, int[] low, int parent, List<Integer>[] graph, boolean[] ap) {
        visited[u] = true;
        disc[u] = low[u] = ++time;
        int children = 0;

        for (int v : graph[u]) {
            if (!visited[v]) {
                children++;
                dfs(v, visited, disc, low, u, graph, ap);
                low[u] = Math.min(low[u], low[v]);

                if (parent != -1 && low[v] >= disc[u])
                    ap[u] = true;
            } else if (v != parent) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }

        if (parent == -1 && children > 1)
            ap[u] = true;
    }

    public static void findArticulationPoints(List<Integer>[] graph, int V) {
        boolean[] visited = new boolean[V];
        int[] disc = new int[V];
        int[] low = new int[V];
        boolean[] ap = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i])
                dfs(i, visited, disc, low, -1, graph, ap);
        }

        System.out.println("Articulation Points:");
        for (int i = 0; i < V; i++) {
            if (ap[i]) System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int V = 5;
        List<Integer>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(1);
        graph[1].add(0);
        graph[0].add(2);
        graph[2].add(0);
        graph[1].add(2);
        graph[2].add(1);
        graph[1].add(3);
        graph[3].add(1);
        graph[3].add(4);
        graph[4].add(3);

        findArticulationPoints(graph, V);
    }
}

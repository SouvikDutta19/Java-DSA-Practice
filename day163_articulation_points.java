import java.util.*;

public class day163_articulation_points {

    static int time;
    static void dfs(int u, int parent, boolean[] visited,
                    int[] disc, int[] low, boolean[] ap,
                    List<List<Integer>> graph) {

        visited[u] = true;
        disc[u] = low[u] = ++time;
        int children = 0;

        for (int v : graph.get(u)) {
            if (!visited[v]) {
                children++;
                dfs(v, u, visited, disc, low, ap, graph);
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

    public static void main(String[] args) {
        int V = 5;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());

        graph.get(0).add(1); graph.get(1).add(0);
        graph.get(1).add(2); graph.get(2).add(1);
        graph.get(2).add(3); graph.get(3).add(2);
        graph.get(1).add(4); graph.get(4).add(1);

        boolean[] visited = new boolean[V];
        int[] disc = new int[V];
        int[] low = new int[V];
        boolean[] ap = new boolean[V];

        dfs(0, -1, visited, disc, low, ap, graph);

        System.out.println("Articulation Points:");
        for (int i = 0; i < V; i++)
            if (ap[i]) System.out.println(i);
    }
}
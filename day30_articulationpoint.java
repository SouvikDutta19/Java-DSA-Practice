import java.util.*;

public class day30_articulationpoint {
    int time = 0;

    void APUtil(int u, boolean[] visited, int[] disc, int[] low, int[] parent, boolean[] ap, List<List<Integer>> graph) {
        int children = 0;
        visited[u] = true;
        disc[u] = low[u] = ++time;

        for (int v : graph.get(u)) {
            if (!visited[v]) {
                children++;
                parent[v] = u;
                APUtil(v, visited, disc, low, parent, ap, graph);
                low[u] = Math.min(low[u], low[v]);

                if (parent[u] == -1 && children > 1) ap[u] = true;
                if (parent[u] != -1 && low[v] >= disc[u]) ap[u] = true;
            } else if (v != parent[u]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    void findAP(List<List<Integer>> graph, int V) {
        boolean[] visited = new boolean[V];
        int[] disc = new int[V];
        int[] low = new int[V];
        int[] parent = new int[V];
        boolean[] ap = new boolean[V];
        Arrays.fill(parent, -1);

        for (int i = 0; i < V; i++)
            if (!visited[i]) APUtil(i, visited, disc, low, parent, ap, graph);

        for (int i = 0; i < V; i++)
            if (ap[i]) System.out.println("Articulation Point: " + i);
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());
        graph.get(0).add(1); graph.get(1).add(0);
        graph.get(0).add(2); graph.get(2).add(0);
        graph.get(1).add(2); graph.get(2).add(1);
        graph.get(1).add(3); graph.get(3).add(1);
        graph.get(3).add(4); graph.get(4).add(3);

        new day30_articulationpoint().findAP(graph, V);
    }
}

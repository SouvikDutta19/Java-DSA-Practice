import java.util.*;

public class day62_articulation_points {
    static int time = 0;

    static void APUtil(int u, boolean[] visited, int[] disc, int[] low, int[] parent, boolean[] ap, List<List<Integer>> adj) {
        int children = 0;
        visited[u] = true;
        disc[u] = low[u] = ++time;

        for (int v : adj.get(u)) {
            if (!visited[v]) {
                children++;
                parent[v] = u;
                APUtil(v, visited, disc, low, parent, ap, adj);
                low[u] = Math.min(low[u], low[v]);

                if (parent[u] == -1 && children > 1)
                    ap[u] = true;
                if (parent[u] != -1 && low[v] >= disc[u])
                    ap[u] = true;
            }
            else if (v != parent[u]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    static void articulationPoints(List<List<Integer>> adj, int V) {
        boolean[] visited = new boolean[V];
        int[] disc = new int[V];
        int[] low = new int[V];
        int[] parent = new int[V];
        boolean[] ap = new boolean[V];

        Arrays.fill(parent, -1);

        for (int i = 0; i < V; i++)
            if (!visited[i]) APUtil(i, visited, disc, low, parent, ap, adj);

        System.out.println("Articulation points:");
        for (int i = 0; i < V; i++)
            if (ap[i]) System.out.print(i + " ");
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        adj.get(0).addAll(Arrays.asList(1, 2));
        adj.get(1).addAll(Arrays.asList(0, 2));
        adj.get(2).addAll(Arrays.asList(0, 1, 3, 4));
        adj.get(3).addAll(Arrays.asList(2, 4));
        adj.get(4).addAll(Arrays.asList(2, 3));

        articulationPoints(adj, V);
    }
}

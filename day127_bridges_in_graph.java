import java.util.*;

public class day127_bridges_in_graph {
    static int time = 0;

    static void dfsBridge(int u, int parent, boolean[] visited, int[] disc, int[] low, List<List<Integer>> adj) {
        visited[u] = true;
        disc[u] = low[u] = ++time;

        for (int v : adj.get(u)) {
            if (v == parent) continue;

            if (!visited[v]) {
                dfsBridge(v, u, visited, disc, low, adj);
                low[u] = Math.min(low[u], low[v]);

                if (low[v] > disc[u])
                    System.out.println(u + " - " + v + " is a Bridge");
            } else
                low[u] = Math.min(low[u], disc[v]);
        }
    }

    static void findBridges(List<List<Integer>> adj, int V) {
        boolean[] visited = new boolean[V];
        int[] disc = new int[V];
        int[] low = new int[V];

        for (int i = 0; i < V; i++)
            if (!visited[i])
                dfsBridge(i, -1, visited, disc, low, adj);
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(0);
        adj.get(0).add(2);
        adj.get(1).add(3);
        adj.get(3).add(1);
        adj.get(3).add(4);
        adj.get(4).add(3);

        findBridges(adj, V);
    }
}

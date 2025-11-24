import java.util.*;

public class day145_find_bridges {

    static int time = 0;

    static void dfs(int u, int parent, boolean[] visited, int[] tin, int[] low, List<List<Integer>> adj) {
        visited[u] = true;
        tin[u] = low[u] = time++;

        for (int v : adj.get(u)) {
            if (v == parent) continue;

            if (!visited[v]) {
                dfs(v, u, visited, tin, low, adj);
                low[u] = Math.min(low[u], low[v]);

                if (low[v] > tin[u])
                    System.out.println("Bridge: " + u + " - " + v);
            } else {
                low[u] = Math.min(low[u], tin[v]);
            }
        }
    }

    static void findBridges(int n, List<List<Integer>> adj) {
        boolean[] visited = new boolean[n];
        int[] tin = new int[n];
        int[] low = new int[n];

        for (int i = 0; i < n; i++)
            if (!visited[i])
                dfs(i, -1, visited, tin, low, adj);
    }

    public static void main(String[] args) {
        int n = 5;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        adj.get(0).add(1); adj.get(1).add(0);
        adj.get(1).add(2); adj.get(2).add(1);
        adj.get(2).add(0); adj.get(0).add(2);
        adj.get(1).add(3); adj.get(3).add(1);
        adj.get(3).add(4); adj.get(4).add(3);

        findBridges(n, adj);
    }
}

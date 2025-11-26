import java.util.*;

public class day147_bridges_tarjan {

    static int timer = 0;

    static void dfs(int u, int parent, boolean[] vis, int[] tin, int[] low, List<List<Integer>> adj, List<int[]> bridges) {
        vis[u] = true;
        tin[u] = low[u] = timer++;
        for (int v : adj.get(u)) {
            if (v == parent) continue;
            if (vis[v]) {
                low[u] = Math.min(low[u], tin[v]);
            } else {
                dfs(v, u, vis, tin, low, adj, bridges);
                low[u] = Math.min(low[u], low[v]);
                if (low[v] > tin[u]) bridges.add(new int[]{u, v});
            }
        }
    }

    public static List<int[]> findBridges(int n, List<List<Integer>> adj) {
        boolean[] vis = new boolean[n];
        int[] tin = new int[n];
        int[] low = new int[n];
        timer = 0;
        List<int[]> bridges = new ArrayList<>();

        for (int i = 0; i < n; i++) if (!vis[i]) dfs(i, -1, vis, tin, low, adj, bridges);

        return bridges;
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

        List<int[]> bridges = findBridges(n, adj);
        System.out.println("Bridges:");
        for (int[] b : bridges) System.out.println(b[0] + " - " + b[1]);
    }
}

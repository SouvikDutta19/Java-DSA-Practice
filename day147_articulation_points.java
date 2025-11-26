import java.util.*;

public class day147_articulation_points {

    static int time = 0;

    static void dfs(int u, int parent, boolean[] vis, int[] tin, int[] low, List<List<Integer>> adj, Set<Integer> ap) {
        vis[u] = true;
        tin[u] = low[u] = time++;
        int children = 0;

        for (int v : adj.get(u)) {
            if (v == parent) continue;
            if (!vis[v]) {
                children++;
                dfs(v, u, vis, tin, low, adj, ap);
                low[u] = Math.min(low[u], low[v]);
                if (parent != -1 && low[v] >= tin[u]) ap.add(u);
            } else {
                low[u] = Math.min(low[u], tin[v]);
            }
        }

        if (parent == -1 && children > 1) ap.add(u);
    }

    public static Set<Integer> findArticulationPoints(int n, List<List<Integer>> adj) {
        boolean[] vis = new boolean[n];
        int[] tin = new int[n];
        int[] low = new int[n];
        Set<Integer> ap = new HashSet<>();
        time = 0;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) dfs(i, -1, vis, tin, low, adj, ap);
        }
        return ap;
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

        Set<Integer> aps = findArticulationPoints(n, adj);
        System.out.println("Articulation Points: " + aps);
    }
}

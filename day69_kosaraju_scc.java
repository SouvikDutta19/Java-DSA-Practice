import java.util.*;

public class day69_kosaraju_scc {
    static void dfs1(int u, boolean[] vis, Stack<Integer> st, List<List<Integer>> adj) {
        vis[u] = true;
        for (int v : adj.get(u)) if (!vis[v]) dfs1(v, vis, st, adj);
        st.push(u);
    }

    static void dfs2(int u, boolean[] vis, List<List<Integer>> radj) {
        vis[u] = true;
        System.out.print(u + " ");
        for (int v : radj.get(u)) if (!vis[v]) dfs2(v, vis, radj);
    }

    public static void main(String[] args) {
        int n = 5;
        List<List<Integer>> adj = new ArrayList<>();
        List<List<Integer>> radj = new ArrayList<>();
        for (int i = 0; i < n; i++) { adj.add(new ArrayList<>()); radj.add(new ArrayList<>()); }
        adj.get(0).add(2); adj.get(2).add(1); adj.get(1).add(0);
        adj.get(0).add(3); adj.get(3).add(4);
        for (int u = 0; u < n; u++) for (int v : adj.get(u)) radj.get(v).add(u);

        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) if (!vis[i]) dfs1(i, vis, st, adj);

        Arrays.fill(vis, false);
        while (!st.isEmpty()) {
            int v = st.pop();
            if (!vis[v]) {
                dfs2(v, vis, radj);
                System.out.println();
            }
        }
    }
}

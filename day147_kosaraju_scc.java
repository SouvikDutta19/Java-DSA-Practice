import java.util.*;

public class day147_kosaraju_scc {

    public static void dfs1(int u, boolean[] vis, Stack<Integer> st, List<List<Integer>> g) {
        vis[u] = true;
        for (int v : g.get(u)) if (!vis[v]) dfs1(v, vis, st, g);
        st.push(u);
    }

    public static void dfs2(int u, boolean[] vis, List<Integer> component, List<List<Integer>> gr) {
        vis[u] = true;
        component.add(u);
        for (int v : gr.get(u)) if (!vis[v]) dfs2(v, vis, component, gr);
    }

    public static List<List<Integer>> kosaraju(int n, List<List<Integer>> g) {
        boolean[] vis = new boolean[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) if (!vis[i]) dfs1(i, vis, st, g);

        // build transpose
        List<List<Integer>> gr = new ArrayList<>();
        for (int i = 0; i < n; i++) gr.add(new ArrayList<>());
        for (int u = 0; u < n; u++) for (int v : g.get(u)) gr.get(v).add(u);

        Arrays.fill(vis, false);
        List<List<Integer>> sccs = new ArrayList<>();
        while (!st.isEmpty()) {
            int node = st.pop();
            if (!vis[node]) {
                List<Integer> comp = new ArrayList<>();
                dfs2(node, vis, comp, gr);
                sccs.add(comp);
            }
        }
        return sccs;
    }

    public static void main(String[] args) {
        int n = 8;
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());

        g.get(0).add(1);
        g.get(1).add(2);
        g.get(2).add(0);
        g.get(2).add(3);
        g.get(3).add(4);
        g.get(4).add(5);
        g.get(5).add(3);
        g.get(6).add(5);
        g.get(6).add(7);

        List<List<Integer>> sccs = kosaraju(n, g);
        System.out.println("SCCs:");
        for (List<Integer> comp : sccs) System.out.println(comp);
    }
}

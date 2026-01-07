import java.util.*;

public class day176_detect_cycle_undirected_graph {

    static boolean dfs(int node, int parent, boolean[] visited, List<List<Integer>> g) {
        visited[node] = true;

        for (int v : g.get(node)) {
            if (!visited[v]) {
                if (dfs(v, node, visited, g)) return true;
            } else if (v != parent) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 4;
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < V; i++) g.add(new ArrayList<>());

        g.get(0).add(1); g.get(1).add(0);
        g.get(1).add(2); g.get(2).add(1);
        g.get(2).add(0); g.get(0).add(2);

        boolean[] visited = new boolean[V];
        System.out.println(dfs(0, -1, visited, g));
    }
}
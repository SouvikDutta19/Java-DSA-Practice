import java.util.*;

public class day181_detect_cycle_directed {

    static boolean dfs(int node, boolean[] visited, boolean[] rec, List<List<Integer>> g) {
        visited[node] = true;
        rec[node] = true;

        for (int nbr : g.get(node)) {
            if (!visited[nbr] && dfs(nbr, visited, rec, g))
                return true;
            else if (rec[nbr])
                return true;
        }

        rec[node] = false;
        return false;
    }

    public static void main(String[] args) {
        int V = 4;
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < V; i++) g.add(new ArrayList<>());

        g.get(0).add(1);
        g.get(1).add(2);
        g.get(2).add(0);

        boolean[] visited = new boolean[V];
        boolean[] rec = new boolean[V];

        System.out.println(dfs(0, visited, rec, g));
    }
}
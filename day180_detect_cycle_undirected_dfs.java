import java.util.*;

public class day180_detect_cycle_undirected_dfs {

    static boolean dfs(int node, int parent, boolean[] visited, List<List<Integer>> graph) {
        visited[node] = true;

        for (int nbr : graph.get(node)) {
            if (!visited[nbr]) {
                if (dfs(nbr, node, visited, graph))
                    return true;
            } else if (nbr != parent) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());

        graph.get(0).add(1); graph.get(1).add(0);
        graph.get(1).add(2); graph.get(2).add(1);
        graph.get(2).add(3); graph.get(3).add(2);
        graph.get(3).add(1); graph.get(1).add(3);

        boolean[] visited = new boolean[V];
        System.out.println(dfs(0, -1, visited, graph));
    }
}
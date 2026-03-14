import java.util.*;

public class day198_cycle_detection_undirected_graph {

    static boolean dfs(int node, int parent, boolean[] visited, List<List<Integer>> adj) {

        visited[node] = true;

        for (int neighbor : adj.get(node)) {

            if (!visited[neighbor]) {
                if (dfs(neighbor, node, visited, adj))
                    return true;
            } 
            else if (neighbor != parent) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int V = 4;

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        adj.get(0).add(1);
        adj.get(1).add(0);

        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(2).add(0);
        adj.get(0).add(2);

        boolean[] visited = new boolean[V];

        System.out.println(dfs(0, -1, visited, adj));
    }
}
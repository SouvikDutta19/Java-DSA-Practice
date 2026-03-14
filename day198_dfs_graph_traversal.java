import java.util.*;

public class day198_dfs_graph_traversal {

    static void dfs(List<List<Integer>> adj, boolean[] visited, int node) {

        visited[node] = true;
        System.out.print(node + " ");

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor])
                dfs(adj, visited, neighbor);
        }
    }

    public static void main(String[] args) {

        int V = 5;
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(3);
        adj.get(2).add(4);

        boolean[] visited = new boolean[V];

        dfs(adj, visited, 0);
    }
}
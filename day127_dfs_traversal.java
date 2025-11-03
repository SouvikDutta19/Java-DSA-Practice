import java.util.*;

public class day127_dfs_traversal {

    static void dfsUtil(int v, boolean[] visited, List<List<Integer>> adj) {
        visited[v] = true;
        System.out.print(v + " ");

        for (int i : adj.get(v))
            if (!visited[i])
                dfsUtil(i, visited, adj);
    }

    static void dfs(List<List<Integer>> adj, int V) {
        boolean[] visited = new boolean[V];
        System.out.println("Depth First Traversal:");
        for (int i = 0; i < V; i++)
            if (!visited[i])
                dfsUtil(i, visited, adj);
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

        dfs(adj, V);
    }
}

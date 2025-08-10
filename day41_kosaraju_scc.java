import java.util.*;

public class day41_kosaraju_scc {
    static void dfs(int v, boolean[] visited, Stack<Integer> stack, List<List<Integer>> adj) {
        visited[v] = true;
        for (int n : adj.get(v)) {
            if (!visited[n])
                dfs(n, visited, stack, adj);
        }
        stack.push(v);
    }

    static void dfsTranspose(int v, boolean[] visited, List<List<Integer>> adjT) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int n : adjT.get(v)) {
            if (!visited[n])
                dfsTranspose(n, visited, adjT);
        }
    }

    public static void kosaraju(List<List<Integer>> adj, int V) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++)
            if (!visited[i])
                dfs(i, visited, stack, adj);

        List<List<Integer>> adjT = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adjT.add(new ArrayList<>());

        for (int v = 0; v < V; v++) {
            for (int n : adj.get(v))
                adjT.get(n).add(v);
        }

        Arrays.fill(visited, false);

        while (!stack.isEmpty()) {
            int v = stack.pop();
            if (!visited[v]) {
                dfsTranspose(v, visited, adjT);
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        adj.get(1).add(0);
        adj.get(0).add(2);
        adj.get(2).add(1);
        adj.get(0).add(3);
        adj.get(3).add(4);

        kosaraju(adj, V);
    }
}

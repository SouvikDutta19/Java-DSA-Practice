import java.util.*;

public class day65_kosaraju_scc {
    static void dfs(int v, boolean[] visited, Stack<Integer> stack, List<List<Integer>> adj) {
        visited[v] = true;
        for (int i : adj.get(v))
            if (!visited[i])
                dfs(i, visited, stack, adj);
        stack.push(v);
    }

    static void dfsTranspose(int v, boolean[] visited, List<List<Integer>> transpose) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int i : transpose.get(v))
            if (!visited[i])
                dfsTranspose(i, visited, transpose);
    }

    static void kosaraju(int V, List<List<Integer>> adj) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++)
            if (!visited[i])
                dfs(i, visited, stack, adj);

        List<List<Integer>> transpose = new ArrayList<>();
        for (int i = 0; i < V; i++) transpose.add(new ArrayList<>());
        for (int v = 0; v < V; v++)
            for (int u : adj.get(v))
                transpose.get(u).add(v);

        Arrays.fill(visited, false);

        System.out.println("Strongly Connected Components:");
        while (!stack.isEmpty()) {
            int v = stack.pop();
            if (!visited[v]) {
                dfsTranspose(v, visited, transpose);
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        adj.get(1).add(0);
        adj.get(0).add(2);
        adj.get(2).add(1);
        adj.get(0).add(3);
        adj.get(3).add(4);

        kosaraju(V, adj);
    }
}

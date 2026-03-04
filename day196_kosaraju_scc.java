import java.util.*;

public class day196_kosaraju_scc {

    private static void dfs(int v, boolean[] visited, Stack<Integer> stack, List<List<Integer>> adj) {
        visited[v] = true;
        for (int nei : adj.get(v))
            if (!visited[nei])
                dfs(nei, visited, stack, adj);
        stack.push(v);
    }

    private static void reverseDfs(int v, boolean[] visited, List<List<Integer>> revAdj) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int nei : revAdj.get(v))
            if (!visited[nei])
                reverseDfs(nei, visited, revAdj);
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

        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++)
            if (!visited[i])
                dfs(i, visited, stack, adj);

        List<List<Integer>> revAdj = new ArrayList<>();
        for (int i = 0; i < V; i++) revAdj.add(new ArrayList<>());

        for (int i = 0; i < V; i++)
            for (int j : adj.get(i))
                revAdj.get(j).add(i);

        Arrays.fill(visited, false);

        System.out.println("Strongly Connected Components:");
        while (!stack.isEmpty()) {
            int v = stack.pop();
            if (!visited[v]) {
                reverseDfs(v, visited, revAdj);
                System.out.println();
            }
        }
    }
}
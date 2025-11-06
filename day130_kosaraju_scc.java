// day130_kosaraju_scc.java
// Kosaraju's algorithm for Strongly Connected Components

import java.util.*;

public class day130_kosaraju_scc {

    private void fillOrder(int v, boolean[] visited, Stack<Integer> stack, List<List<Integer>> adj) {
        visited[v] = true;
        for (int n : adj.get(v))
            if (!visited[n])
                fillOrder(n, visited, stack, adj);
        stack.push(v);
    }

    private List<List<Integer>> transpose(int V, List<List<Integer>> adj) {
        List<List<Integer>> rev = new ArrayList<>();
        for (int i = 0; i < V; i++) rev.add(new ArrayList<>());
        for (int i = 0; i < V; i++)
            for (int j : adj.get(i))
                rev.get(j).add(i);
        return rev;
    }

    private void dfsUtil(int v, boolean[] visited, List<Integer> component, List<List<Integer>> adj) {
        visited[v] = true;
        component.add(v);
        for (int n : adj.get(v))
            if (!visited[n])
                dfsUtil(n, visited, component, adj);
    }

    public List<List<Integer>> kosaraju(int V, List<List<Integer>> adj) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++)
            if (!visited[i])
                fillOrder(i, visited, stack, adj);

        List<List<Integer>> rev = transpose(V, adj);

        Arrays.fill(visited, false);
        List<List<Integer>> sccs = new ArrayList<>();

        while (!stack.isEmpty()) {
            int v = stack.pop();
            if (!visited[v]) {
                List<Integer> component = new ArrayList<>();
                dfsUtil(v, visited, component, rev);
                sccs.add(component);
            }
        }
        return sccs;
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

        day130_kosaraju_scc solver = new day130_kosaraju_scc();
        List<List<Integer>> sccs = solver.kosaraju(V, adj);
        System.out.println("Strongly Connected Components:");
        for (List<Integer> comp : sccs) System.out.println(comp);
    }
}

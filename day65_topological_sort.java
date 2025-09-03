import java.util.*;

public class day65_topological_sort {
    static void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> stack, List<List<Integer>> adj) {
        visited[v] = true;
        for (int i : adj.get(v))
            if (!visited[i])
                topologicalSortUtil(i, visited, stack, adj);
        stack.push(v);
    }

    static void topologicalSort(int V, List<List<Integer>> adj) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++)
            if (!visited[i])
                topologicalSortUtil(i, visited, stack, adj);

        System.out.println("Topological Sort:");
        while (!stack.isEmpty())
            System.out.print(stack.pop() + " ");
    }

    public static void main(String[] args) {
        int V = 6;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        topologicalSort(V, adj);
    }
}

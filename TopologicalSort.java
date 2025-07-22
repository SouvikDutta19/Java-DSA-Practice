import java.util.*;

public class TopologicalSort {
    private final int V;
    private final List<List<Integer>> adj;

    TopologicalSort(int v) {
        V = v;
        adj = new ArrayList<>();
        for (int i = 0; i < v; i++)
            adj.add(new ArrayList<>());
    }

    void addEdge(int v, int w) {
        adj.get(v).add(w);
    }

    void topologicalSort() {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < V; i++)
            if (!visited[i])
                dfs(i, visited, stack);
        while (!stack.isEmpty())
            System.out.print(stack.pop() + " ");
    }

    void dfs(int v, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;
        for (int n : adj.get(v))
            if (!visited[n])
                dfs(n, visited, stack);
        stack.push(v);
    }

    public static void main(String[] args) {
        TopologicalSort g = new TopologicalSort(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        g.topologicalSort();
    }
}

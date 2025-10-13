import java.util.*;

// Topological Sorting using DFS
public class day107_topological_sort {
    private final int V;
    private final List<List<Integer>> adj;

    day107_topological_sort(int v) {
        V = v;
        adj = new ArrayList<>();
        for (int i = 0; i < v; i++)
            adj.add(new ArrayList<>());
    }

    void addEdge(int v, int w) {
        adj.get(v).add(w);
    }

    void dfs(int v, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;
        for (int i : adj.get(v))
            if (!visited[i])
                dfs(i, visited, stack);
        stack.push(v);
    }

    void topologicalSort() {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++)
            if (!visited[i])
                dfs(i, visited, stack);
        System.out.println("Topological Sort:");
        while (!stack.isEmpty()) System.out.print(stack.pop() + " ");
    }

    public static void main(String[] args) {
        day107_topological_sort g = new day107_topological_sort(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        g.topologicalSort();
    }
}

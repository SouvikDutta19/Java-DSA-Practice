import java.util.*;

public class day110_topological_sort_dfs {
    private final int vertices;
    private final List<List<Integer>> adj;

    public day110_topological_sort_dfs(int v) {
        vertices = v;
        adj = new ArrayList<>();
        for (int i = 0; i < v; i++)
            adj.add(new ArrayList<>());
    }

    void addEdge(int v, int w) {
        adj.get(v).add(w);
    }

    void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;
        for (int n : adj.get(v))
            if (!visited[n])
                topologicalSortUtil(n, visited, stack);
        stack.push(v);
    }

    void topologicalSort() {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++)
            if (!visited[i])
                topologicalSortUtil(i, visited, stack);

        System.out.println("Topological Sort (DFS):");
        while (!stack.isEmpty())
            System.out.print(stack.pop() + " ");
    }

    public static void main(String[] args) {
        day110_topological_sort_dfs g = new day110_topological_sort_dfs(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        g.topologicalSort();
    }
}

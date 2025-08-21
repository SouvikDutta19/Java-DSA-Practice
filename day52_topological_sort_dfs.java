import java.util.*;

public class day52_topological_sort_dfs {
    private int V;
    private List<List<Integer>> adj;

    public day52_topological_sort_dfs(int v) {
        V = v;
        adj = new ArrayList<>();
        for (int i = 0; i < v; i++) adj.add(new ArrayList<>());
    }

    public void addEdge(int u, int v) {
        adj.get(u).add(v);
    }

    private void dfs(int v, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;
        for (int n : adj.get(v)) {
            if (!visited[n]) dfs(n, visited, stack);
        }
        stack.push(v);
    }

    public void topologicalSort() {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) dfs(i, visited, stack);
        }

        System.out.println("Topological Order:");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public static void main(String[] args) {
        day52_topological_sort_dfs g = new day52_topological_sort_dfs(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        g.topologicalSort();
    }
}

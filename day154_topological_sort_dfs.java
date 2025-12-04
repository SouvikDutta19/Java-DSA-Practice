import java.util.*;

public class day154_topological_sort_dfs {

    private int V;
    private List<Integer>[] adj;

    day154_topological_sort_dfs(int v) {
        V = v;
        adj = new List[v];
        for (int i = 0; i < v; i++) adj[i] = new ArrayList<>();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void topologicalSortUtil(int v, boolean visited[], Stack<Integer> stack) {
        visited[v] = true;

        for (Integer i : adj[v]) {
            if (!visited[i])
                topologicalSortUtil(i, visited, stack);
        }

        stack.push(v);
    }

    void topologicalSort() {
        Stack<Integer> stack = new Stack<>();
        boolean visited[] = new boolean[V];

        for (int i = 0; i < V; i++)
            if (!visited[i])
                topologicalSortUtil(i, visited, stack);

        while (!stack.empty())
            System.out.print(stack.pop() + " ");
    }

    public static void main(String[] args) {
        day154_topological_sort_dfs g = new day154_topological_sort_dfs(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.print("Topological Sort: ");
        g.topologicalSort();
    }
}
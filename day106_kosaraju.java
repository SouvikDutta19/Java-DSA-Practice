import java.util.*;

// Kosaraju's algorithm to find Strongly Connected Components (SCCs)
public class day106_kosaraju {
    private int V;
    private List<List<Integer>> adj;

    public day106_kosaraju(int v) {
        V = v;
        adj = new ArrayList<>();
        for (int i = 0; i < v; i++) adj.add(new ArrayList<>());
    }

    void addEdge(int u, int v) { adj.get(u).add(v); }

    void fillOrder(int v, boolean[] visited, Deque<Integer> stack) {
        visited[v] = true;
        for (int n : adj.get(v)) if (!visited[n]) fillOrder(n, visited, stack);
        stack.push(v);
    }

    List<List<Integer>> transpose() {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < V; i++) g.add(new ArrayList<>());
        for (int v = 0; v < V; v++)
            for (int u : adj.get(v)) g.get(u).add(v);
        return g;
    }

    void dfs(int v, boolean[] visited, List<Integer> component, List<List<Integer>> g) {
        visited[v] = true;
        component.add(v);
        for (int n : g.get(v)) if (!visited[n]) dfs(n, visited, component, g);
    }

    public List<List<Integer>> getSCCs() {
        Deque<Integer> stack = new ArrayDeque<>();
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) if (!visited[i]) fillOrder(i, visited, stack);
        List<List<Integer>> gr = transpose();
        Arrays.fill(visited, false);
        List<List<Integer>> sccs = new ArrayList<>();
        while (!stack.isEmpty()) {
            int v = stack.pop();
            if (!visited[v]) {
                List<Integer> component = new ArrayList<>();
                dfs(v, visited, component, gr);
                sccs.add(component);
            }
        }
        return sccs;
    }

    public static void main(String[] args) {
        day106_kosaraju g = new day106_kosaraju(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);
        List<List<Integer>> sccs = g.getSCCs();
        System.out.println("Strongly Connected Components:");
        for (List<Integer> comp : sccs) System.out.println(comp);
    }
}

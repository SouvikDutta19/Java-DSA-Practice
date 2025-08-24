import java.util.*;

public class day55_detect_cycle_in_graph {
    private int V;
    private List<List<Integer>> adj;

    public day55_detect_cycle_in_graph(int v) {
        V = v;
        adj = new ArrayList<>();
        for (int i = 0; i < v; i++) adj.add(new ArrayList<>());
    }

    public void addEdge(int u, int v) {
        adj.get(u).add(v);
    }

    public boolean isCyclic() {
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (dfs(i, visited, recStack)) return true;
        }
        return false;
    }

    private boolean dfs(int node, boolean[] visited, boolean[] recStack) {
        if (recStack[node]) return true;
        if (visited[node]) return false;

        visited[node] = true;
        recStack[node] = true;

        for (int neighbor : adj.get(node)) {
            if (dfs(neighbor, visited, recStack)) return true;
        }

        recStack[node] = false;
        return false;
    }

    public static void main(String[] args) {
        day55_detect_cycle_in_graph graph = new day55_detect_cycle_in_graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);

        System.out.println("Does graph contain cycle? " + graph.isCyclic());
    }
}

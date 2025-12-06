import java.util.*;

public class day156_directed_graph_cycle_detection {

    private int V;
    private List<Integer>[] adj;

    day156_directed_graph_cycle_detection(int v) {
        V = v;
        adj = new ArrayList[v];
        for (int i = 0; i < v; i++)
            adj[i] = new ArrayList<>();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    boolean dfs(int v, boolean visited[], boolean recStack[]) {
        if (recStack[v]) return true;
        if (visited[v]) return false;

        visited[v] = true;
        recStack[v] = true;

        for (int n : adj[v]) {
            if (dfs(n, visited, recStack))
                return true;
        }

        recStack[v] = false;
        return false;
    }

    boolean hasCycle() {
        boolean visited[] = new boolean[V];
        boolean recStack[] = new boolean[V];

        for (int i = 0; i < V; i++)
            if (dfs(i, visited, recStack))
                return true;

        return false;
    }

    public static void main(String[] args) {
        day156_directed_graph_cycle_detection graph = new day156_directed_graph_cycle_detection(4);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);

        System.out.println("Cycle present? " + graph.hasCycle());
    }
}
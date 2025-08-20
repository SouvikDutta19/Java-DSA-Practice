import java.util.*;

public class day51_bridge_detection {
    private int V, time;
    private LinkedList<Integer>[] adj;

    day51_bridge_detection(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) adj[i] = new LinkedList<>();
    }

    void addEdge(int v, int w) { adj[v].add(w); adj[w].add(v); }

    void bridgeUtil(int u, boolean visited[], int disc[], int low[], int parent[]) {
        visited[u] = true; disc[u] = low[u] = ++time;
        for (int v : adj[u]) {
            if (!visited[v]) {
                parent[v] = u; bridgeUtil(v, visited, disc, low, parent);
                low[u] = Math.min(low[u], low[v]);
                if (low[v] > disc[u]) System.out.println(u + " - " + v);
            } else if (v != parent[u]) low[u] = Math.min(low[u], disc[v]);
        }
    }

    void bridge() {
        boolean visited[] = new boolean[V];
        int disc[] = new int[V], low[] = new int[V], parent[] = new int[V];
        Arrays.fill(parent, -1);
        for (int i = 0; i < V; i++) if (!visited[i]) bridgeUtil(i, visited, disc, low, parent);
    }

    public static void main(String args[]) {
        day51_bridge_detection g = new day51_bridge_detection(5);
        g.addEdge(1, 0); g.addEdge(0, 2); g.addEdge(2, 1);
        g.addEdge(0, 3); g.addEdge(3, 4);
        System.out.println("Bridges in graph:");
        g.bridge();
    }
}

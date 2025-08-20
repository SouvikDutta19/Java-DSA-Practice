import java.util.*;

public class day51_articulation_points {
    private int V, time;
    private LinkedList<Integer>[] adj;

    day51_articulation_points(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) adj[i] = new LinkedList<>();
    }

    void addEdge(int v, int w) { adj[v].add(w); adj[w].add(v); }

    void APUtil(int u, boolean visited[], int disc[], int low[], int parent[], boolean ap[]) {
        int children = 0; visited[u] = true; disc[u] = low[u] = ++time;
        for (int v : adj[u]) {
            if (!visited[v]) {
                children++; parent[v] = u; APUtil(v, visited, disc, low, parent, ap);
                low[u] = Math.min(low[u], low[v]);
                if (parent[u] == -1 && children > 1) ap[u] = true;
                if (parent[u] != -1 && low[v] >= disc[u]) ap[u] = true;
            } else if (v != parent[u]) low[u] = Math.min(low[u], disc[v]);
        }
    }

    void AP() {
        boolean visited[] = new boolean[V], ap[] = new boolean[V];
        int parent[] = new int[V], disc[] = new int[V], low[] = new int[V];
        Arrays.fill(parent, -1);
        for (int i = 0; i < V; i++) if (!visited[i]) APUtil(i, visited, disc, low, parent, ap);
        System.out.println("Articulation points:");
        for (int i = 0; i < V; i++) if (ap[i]) System.out.print(i + " ");
    }

    public static void main(String args[]) {
        day51_articulation_points g = new day51_articulation_points(5);
        g.addEdge(1, 0); g.addEdge(0, 2); g.addEdge(2, 1);
        g.addEdge(0, 3); g.addEdge(3, 4);
        g.AP();
    }
}

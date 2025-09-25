import java.util.*;

public class day90_articulation_points {
    private int V;
    private List<List<Integer>> adj;
    private int time;

    public day90_articulation_points(int v) {
        V = v;
        adj = new ArrayList<>();
        for (int i = 0; i < v; i++) adj.add(new ArrayList<>());
    }

    void addEdge(int v, int w) { adj.get(v).add(w); adj.get(w).add(v); }

    void APUtil(int u, boolean visited[], int disc[], int low[], int parent[], boolean ap[]) {
        int children = 0;
        visited[u] = true;
        disc[u] = low[u] = ++time;

        for (int v : adj.get(u)) {
            if (!visited[v]) {
                children++;
                parent[v] = u;
                APUtil(v, visited, disc, low, parent, ap);
                low[u] = Math.min(low[u], low[v]);

                if (parent[u] == -1 && children > 1) ap[u] = true;
                if (parent[u] != -1 && low[v] >= disc[u]) ap[u] = true;
            } else if (v != parent[u]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    void articulationPoints() {
        boolean visited[] = new boolean[V];
        int disc[] = new int[V], low[] = new int[V], parent[] = new int[V];
        boolean ap[] = new boolean[V];
        Arrays.fill(parent, -1);

        for (int i = 0; i < V; i++) if (!visited[i]) APUtil(i, visited, disc, low, parent, ap);

        for (int i = 0; i < V; i++) if (ap[i]) System.out.print(i + " ");
    }

    public static void main(String[] args) {
        day90_articulation_points g = new day90_articulation_points(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);
        System.out.print("Articulation points: ");
        g.articulationPoints();
    }
}

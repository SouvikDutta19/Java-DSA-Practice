import java.util.*;

public class day47_articulation_points {
    private int V;
    private LinkedList<Integer>[] adj;
    private int time;
    private boolean[] visited, ap;
    private int[] disc, low, parent;

    public day47_articulation_points(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) adj[i] = new LinkedList<>();
        visited = new boolean[v];
        ap = new boolean[v];
        disc = new int[v];
        low = new int[v];
        parent = new int[v];
        Arrays.fill(parent, -1);
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    void APUtil(int u) {
        int children = 0;
        visited[u] = true;
        disc[u] = low[u] = ++time;
        for (int v : adj[u]) {
            if (!visited[v]) {
                children++;
                parent[v] = u;
                APUtil(v);
                low[u] = Math.min(low[u], low[v]);
                if (parent[u] == -1 && children > 1) ap[u] = true;
                if (parent[u] != -1 && low[v] >= disc[u]) ap[u] = true;
            } else if (v != parent[u]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    void articulationPoints() {
        for (int i = 0; i < V; i++) if (!visited[i]) APUtil(i);
        System.out.println("Articulation Points:");
        for (int i = 0; i < V; i++) if (ap[i]) System.out.print(i + " ");
    }

    public static void main(String[] args) {
        day47_articulation_points g = new day47_articulation_points(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);
        g.articulationPoints();
    }
}

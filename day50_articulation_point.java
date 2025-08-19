import java.util.*;

public class day50_articulation_point {
    private int V;
    private LinkedList<Integer>[] adj;
    private int time = 0;

    day50_articulation_point(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<>();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    void APUtil(int u, boolean visited[], int disc[], int low[], int parent[], boolean ap[]) {
        int children = 0;
        visited[u] = true;
        disc[u] = low[u] = ++time;

        for (int v : adj[u]) {
            if (!visited[v]) {
                children++;
                parent[v] = u;
                APUtil(v, visited, disc, low, parent, ap);
                low[u] = Math.min(low[u], low[v]);

                if (parent[u] == -1 && children > 1)
                    ap[u] = true;
                if (parent[u] != -1 && low[v] >= disc[u])
                    ap[u] = true;
            } else if (v != parent[u]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    void articulationPoints() {
        boolean visited[] = new boolean[V];
        int disc[] = new int[V];
        int low[] = new int[V];
        int parent[] = new int[V];
        boolean ap[] = new boolean[V];

        Arrays.fill(parent, -1);

        for (int i = 0; i < V; i++)
            if (!visited[i])
                APUtil(i, visited, disc, low, parent, ap);

        System.out.println("Articulation points in the graph:");
        for (int i = 0; i < V; i++)
            if (ap[i]) System.out.print(i + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        day50_articulation_point g = new day50_articulation_point(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);
        g.articulationPoints();
    }
}

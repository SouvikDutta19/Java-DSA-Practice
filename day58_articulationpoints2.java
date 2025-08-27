import java.util.*;

public class day58_articulationpoints2 {
    private int V;
    private LinkedList<Integer>[] adj;
    private int time;
    private int[] disc, low, parent;
    private boolean[] articulationPoint;

    public day58_articulationpoints2(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) adj[i] = new LinkedList<>();
        time = 0;
        disc = new int[v];
        low = new int[v];
        parent = new int[v];
        Arrays.fill(parent, -1);
        articulationPoint = new boolean[v];
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    void APUtil(int u) {
        int children = 0;
        disc[u] = low[u] = ++time;
        for (int v : adj[u]) {
            if (disc[v] == 0) {
                children++;
                parent[v] = u;
                APUtil(v);
                low[u] = Math.min(low[u], low[v]);
                if (parent[u] == -1 && children > 1)
                    articulationPoint[u] = true;
                if (parent[u] != -1 && low[v] >= disc[u])
                    articulationPoint[u] = true;
            } else if (v != parent[u]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    void AP() {
        for (int i = 0; i < V; i++) {
            if (disc[i] == 0) APUtil(i);
        }
        System.out.println("Articulation points:");
        for (int i = 0; i < V; i++) {
            if (articulationPoint[i]) System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        day58_articulationpoints g = new day58_articulationpoints(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);
        g.AP();
    }
}

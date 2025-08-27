// day58_bridgesingraph.java
import java.util.*;

public class day58_bridgesingraph {
    private int V;
    private LinkedList<Integer> adj[];
    int time = 0;
    static final int NIL = -1;

    day58_bridgesingraph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<>();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    void bridgeUtil(int u, boolean visited[], int disc[], int low[], int parent[]) {
        visited[u] = true;
        disc[u] = low[u] = ++time;

        for (Integer v : adj[u]) {
            if (!visited[v]) {
                parent[v] = u;
                bridgeUtil(v, visited, disc, low, parent);
                low[u] = Math.min(low[u], low[v]);
                if (low[v] > disc[u])
                    System.out.println(u + " -- " + v);
            } else if (v != parent[u])
                low[u] = Math.min(low[u], disc[v]);
        }
    }

    void bridge() {
        boolean visited[] = new boolean[V];
        int disc[] = new int[V];
        int low[] = new int[V];
        int parent[] = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = NIL;
            visited[i] = false;
        }
        for (int i = 0; i < V; i++)
            if (!visited[i])
                bridgeUtil(i, visited, disc, low, parent);
    }

    public static void main(String args[]) {
        day58_bridgesingraph g1 = new day58_bridgesingraph(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        System.out.println("Bridges in graph:");
        g1.bridge();
    }
}

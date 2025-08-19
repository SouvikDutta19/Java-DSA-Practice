import java.util.*;

public class day50_bridges_in_graph {
    private int V;
    private LinkedList<Integer>[] adj;
    private int time = 0;

    day50_bridges_in_graph(int v) {
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

        for (int v : adj[u]) {
            if (!visited[v]) {
                parent[v] = u;
                bridgeUtil(v, visited, disc, low, parent);
                low[u] = Math.min(low[u], low[v]);

                if (low[v] > disc[u])
                    System.out.println(u + " -- " + v + " is a bridge");
            } else if (v != parent[u]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    void findBridges() {
        boolean visited[] = new boolean[V];
        int disc[] = new int[V];
        int low[] = new int[V];
        int parent[] = new int[V];
        Arrays.fill(parent, -1);

        for (int i = 0; i < V; i++)
            if (!visited[i])
                bridgeUtil(i, visited, disc, low, parent);
    }

    public static void main(String args[]) {
        day50_bridges_in_graph g = new day50_bridges_in_graph(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);
        g.findBridges();
    }
}

import java.util.*;

public class day58_bridgesingraph2 {
    private int V, time;
    private LinkedList<Integer>[] adj;
    private int[] disc, low, parent;

    public day58_bridgesingraph2(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) adj[i] = new LinkedList<>();
        disc = new int[v];
        low = new int[v];
        parent = new int[v];
        Arrays.fill(parent, -1);
        time = 0;
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    void bridgeUtil(int u) {
        disc[u] = low[u] = ++time;
        for (int v : adj[u]) {
            if (disc[v] == 0) {
                parent[v] = u;
                bridgeUtil(v);
                low[u] = Math.min(low[u], low[v]);
                if (low[v] > disc[u])
                    System.out.println(u + " - " + v + " is a bridge");
            } else if (v != parent[u]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    void bridge() {
        for (int i = 0; i < V; i++) {
            if (disc[i] == 0) bridgeUtil(i);
        }
    }

    public static void main(String[] args) {
        day58_bridgesingraph g = new day58_bridgesingraph(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);
        g.bridge();
    }
}

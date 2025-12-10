class EdgeBF {
    int u, v, w;
    EdgeBF(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }
}

public class day160_bellman_ford {

    static void bellmanFord(EdgeBF[] edges, int V, int src) {
        int[] dist = new int[V];
        for (int i = 0; i < V; i++) dist[i] = Integer.MAX_VALUE;
        dist[src] = 0;

        for (int i = 1; i < V; i++) {
            for (EdgeBF e : edges) {
                if (dist[e.u] != Integer.MAX_VALUE &&
                        dist[e.u] + e.w < dist[e.v]) {
                    dist[e.v] = dist[e.u] + e.w;
                }
            }
        }

        for (EdgeBF e : edges) {
            if (dist[e.u] != Integer.MAX_VALUE &&
                    dist[e.u] + e.w < dist[e.v]) {
                System.out.println("Negative weight cycle detected");
                return;
            }
        }

        for (int i = 0; i < V; i++) {
            System.out.println(i + " -> " + dist[i]);
        }
    }

    public static void main(String[] args) {
        EdgeBF[] edges = {
                new EdgeBF(0, 1, -1),
                new EdgeBF(0, 2, 4),
                new EdgeBF(1, 2, 3),
                new EdgeBF(1, 3, 2),
                new EdgeBF(1, 4, 2),
                new EdgeBF(3, 2, 5),
                new EdgeBF(3, 1, 1),
                new EdgeBF(4, 3, -3)
        };

        bellmanFord(edges, 5, 0);
    }
}
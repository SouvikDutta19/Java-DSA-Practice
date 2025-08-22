import java.util.*;

class EdgeBF {
    int u, v, w;
    EdgeBF(int u, int v, int w) { this.u = u; this.v = v; this.w = w; }
}

public class day53_bellman_ford {
    public static void bellmanFord(List<EdgeBF> edges, int V, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int i = 0; i < V - 1; i++) {
            for (EdgeBF e : edges) {
                if (dist[e.u] != Integer.MAX_VALUE && dist[e.u] + e.w < dist[e.v]) {
                    dist[e.v] = dist[e.u] + e.w;
                }
            }
        }

        for (EdgeBF e : edges) {
            if (dist[e.u] != Integer.MAX_VALUE && dist[e.u] + e.w < dist[e.v]) {
                System.out.println("Graph contains negative weight cycle");
                return;
            }
        }

        System.out.println("Shortest distances: " + Arrays.toString(dist));
    }

    public static void main(String[] args) {
        int V = 5;
        List<EdgeBF> edges = new ArrayList<>();
        edges.add(new EdgeBF(0, 1, -1));
        edges.add(new EdgeBF(0, 2, 4));
        edges.add(new EdgeBF(1, 2, 3));
        edges.add(new EdgeBF(1, 3, 2));
        edges.add(new EdgeBF(1, 4, 2));
        edges.add(new EdgeBF(3, 2, 5));
        edges.add(new EdgeBF(3, 1, 1));
        edges.add(new EdgeBF(4, 3, -3));

        bellmanFord(edges, V, 0);
    }
}

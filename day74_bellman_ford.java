import java.util.*;

public class day74_bellman_ford {
    static class Edge {
        int u, v, w;
        Edge(int u, int v, int w) { this.u = u; this.v = v; this.w = w; }
    }

    public static void main(String[] args) {
        int V = 5, E = 8;
        Edge[] edges = {
            new Edge(0,1,-1), new Edge(0,2,4), new Edge(1,2,3),
            new Edge(1,3,2), new Edge(1,4,2), new Edge(3,2,5),
            new Edge(3,1,1), new Edge(4,3,-3)
        };

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        for (int i = 1; i < V; i++) {
            for (Edge e : edges) {
                if (dist[e.u] != Integer.MAX_VALUE && dist[e.u] + e.w < dist[e.v]) {
                    dist[e.v] = dist[e.u] + e.w;
                }
            }
        }

        for (Edge e : edges) {
            if (dist[e.u] != Integer.MAX_VALUE && dist[e.u] + e.w < dist[e.v]) {
                System.out.println("Graph contains negative weight cycle!");
                return;
            }
        }

        System.out.println("Shortest distances:");
        for (int i = 0; i < V; i++) System.out.println(i + " -> " + dist[i]);
    }
}

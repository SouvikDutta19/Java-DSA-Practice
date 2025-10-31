// day124_bellman_ford.java
import java.util.*;

public class day124_bellman_ford {
    static class Edge {
        int u, v, w;
        Edge(int u, int v, int w) { this.u = u; this.v = v; this.w = w; }
    }

    public static int[] bellmanFord(int V, List<Edge> edges, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int i = 1; i <= V - 1; i++) {
            boolean updated = false;
            for (Edge e : edges) {
                if (dist[e.u] != Integer.MAX_VALUE && dist[e.u] + e.w < dist[e.v]) {
                    dist[e.v] = dist[e.u] + e.w;
                    updated = true;
                }
            }
            if (!updated) break;
        }

        // check negative cycle
        for (Edge e : edges) {
            if (dist[e.u] != Integer.MAX_VALUE && dist[e.u] + e.w < dist[e.v]) {
                throw new RuntimeException("Graph contains negative weight cycle");
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int V = 5;
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0,1,-1));
        edges.add(new Edge(0,2,4));
        edges.add(new Edge(1,2,3));
        edges.add(new Edge(1,3,2));
        edges.add(new Edge(1,4,2));
        edges.add(new Edge(3,2,5));
        edges.add(new Edge(3,1,1));
        edges.add(new Edge(4,3,-3));

        int src = 0;
        try {
            int[] dist = bellmanFord(V, edges, src);
            System.out.println("Vertex Distance from Source " + src + ":");
            for (int i = 0; i < V; i++) System.out.println(i + " -> " + dist[i]);
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

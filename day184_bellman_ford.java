import java.util.*;

public class day184_bellman_ford {

    static class Edge {
        int u, v, w;
        Edge(int a, int b, int c) { u = a; v = b; w = c; }
    }

    static void bellmanFord(List<Edge> edges, int V, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int i = 1; i < V; i++) {
            for (Edge e : edges) {
                if (dist[e.u] != Integer.MAX_VALUE &&
                    dist[e.u] + e.w < dist[e.v])
                    dist[e.v] = dist[e.u] + e.w;
            }
        }

        for (int i = 0; i < V; i++)
            System.out.println(src + " -> " + i + " = " + dist[i]);
    }

    public static void main(String[] args) {
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0,1,4));
        edges.add(new Edge(0,2,5));
        edges.add(new Edge(1,2,-3));
        edges.add(new Edge(2,3,4));

        bellmanFord(edges, 4, 0);
    }
}
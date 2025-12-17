import java.util.*;

public class day167_bellman_ford_algorithm {

    static class Edge {
        int u, v, wt;
        Edge(int u, int v, int wt) {
            this.u = u;
            this.v = v;
            this.wt = wt;
        }
    }

    public static void bellmanFord(int V, List<Edge> edges, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int i = 1; i < V; i++) {
            for (Edge e : edges) {
                if (dist[e.u] != Integer.MAX_VALUE &&
                    dist[e.u] + e.wt < dist[e.v]) {
                    dist[e.v] = dist[e.u] + e.wt;
                }
            }
        }

        for (Edge e : edges) {
            if (dist[e.u] != Integer.MAX_VALUE &&
                dist[e.u] + e.wt < dist[e.v]) {
                System.out.println("Negative cycle detected");
                return;
            }
        }

        System.out.println("Shortest distances:");
        for (int i = 0; i < V; i++)
            System.out.println(i + " -> " + dist[i]);
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

        bellmanFord(V, edges, 0);
    }
}
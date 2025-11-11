import java.util.*;

public class day135_bellman_ford_shortest_path {
    static class Edge {
        int src, dest, weight;
        Edge(int s, int d, int w) { src = s; dest = d; weight = w; }
    }

    static void bellmanFord(List<Edge> edges, int V, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int i = 1; i < V; i++) {
            for (Edge e : edges) {
                if (dist[e.src] != Integer.MAX_VALUE && dist[e.src] + e.weight < dist[e.dest])
                    dist[e.dest] = dist[e.src] + e.weight;
            }
        }

        for (Edge e : edges) {
            if (dist[e.src] != Integer.MAX_VALUE && dist[e.src] + e.weight < dist[e.dest]) {
                System.out.println("Graph contains negative weight cycle");
                return;
            }
        }

        for (int i = 0; i < V; i++)
            System.out.println("Distance to " + i + " = " + dist[i]);
    }

    public static void main(String[] args) {
        List<Edge> edges = Arrays.asList(
            new Edge(0, 1, -1), new Edge(0, 2, 4),
            new Edge(1, 2, 3), new Edge(1, 3, 2),
            new Edge(1, 4, 2), new Edge(3, 2, 5),
            new Edge(3, 1, 1), new Edge(4, 3, -3)
        );
        bellmanFord(edges, 5, 0);
    }
}

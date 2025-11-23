import java.util.*;

class EdgeBF {
    int src, dest, weight;
    EdgeBF(int s, int d, int w) {
        src = s; dest = d; weight = w;
    }
}

public class day144_bellman_ford {

    public static void bellmanFord(List<EdgeBF> edges, int n, int src) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int i = 1; i < n; i++) {
            for (EdgeBF e : edges) {
                if (dist[e.src] != Integer.MAX_VALUE &&
                        dist[e.src] + e.weight < dist[e.dest]) {
                    dist[e.dest] = dist[e.src] + e.weight;
                }
            }
        }

        for (EdgeBF e : edges) {
            if (dist[e.src] != Integer.MAX_VALUE &&
                    dist[e.src] + e.weight < dist[e.dest]) {
                System.out.println("Graph contains negative weight cycle!");
                return;
            }
        }

        System.out.println("Shortest Distances from Source:");
        for (int i = 0; i < n; i++)
            System.out.println(i + " -> " + dist[i]);
    }

    public static void main(String[] args) {
        List<EdgeBF> edges = Arrays.asList(
                new EdgeBF(0, 1, -1),
                new EdgeBF(0, 2, 4),
                new EdgeBF(1, 2, 3),
                new EdgeBF(1, 3, 2),
                new EdgeBF(1, 4, 2),
                new EdgeBF(3, 2, 5),
                new EdgeBF(3, 1, 1),
                new EdgeBF(4, 3, -3)
        );

        bellmanFord(edges, 5, 0);
    }
}

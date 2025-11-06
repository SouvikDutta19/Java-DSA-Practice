import java.util.*;

class BellmanEdge {
    int src, dest, weight;
    BellmanEdge(int s, int d, int w) { src = s; dest = d; weight = w; }
}

public class day130_bellman_ford {
    void bellmanFord(int V, List<BellmanEdge> edges, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int i = 1; i < V; ++i) {
            for (BellmanEdge e : edges) {
                if (dist[e.src] != Integer.MAX_VALUE && dist[e.src] + e.weight < dist[e.dest]) {
                    dist[e.dest] = dist[e.src] + e.weight;
                }
            }
        }

        for (BellmanEdge e : edges) {
            if (dist[e.src] != Integer.MAX_VALUE && dist[e.src] + e.weight < dist[e.dest]) {
                System.out.println("Graph contains negative weight cycle!");
                return;
            }
        }

        System.out.println("Vertex Distance from Source:");
        for (int i = 0; i < V; ++i)
            System.out.println(i + "\t\t" + dist[i]);
    }

    public static void main(String[] args) {
        int V = 5;
        List<BellmanEdge> edges = new ArrayList<>();
        edges.add(new BellmanEdge(0, 1, -1));
        edges.add(new BellmanEdge(0, 2, 4));
        edges.add(new BellmanEdge(1, 2, 3));
        edges.add(new BellmanEdge(1, 3, 2));
        edges.add(new BellmanEdge(1, 4, 2));
        edges.add(new BellmanEdge(3, 2, 5));
        edges.add(new BellmanEdge(3, 1, 1));
        edges.add(new BellmanEdge(4, 3, -3));

        new day130_bellman_ford().bellmanFord(V, edges, 0);
    }
}

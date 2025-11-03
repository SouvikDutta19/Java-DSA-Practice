import java.util.*;

class EdgeBF {
    int src, dest, weight;
    EdgeBF(int s, int d, int w) { src = s; dest = d; weight = w; }
}

public class day127_bellman_ford {

    void bellmanFord(List<EdgeBF> edges, int V, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int i = 1; i < V; i++) {
            for (EdgeBF edge : edges) {
                if (dist[edge.src] != Integer.MAX_VALUE && dist[edge.src] + edge.weight < dist[edge.dest])
                    dist[edge.dest] = dist[edge.src] + edge.weight;
            }
        }

        for (EdgeBF edge : edges)
            if (dist[edge.src] + edge.weight < dist[edge.dest])
                System.out.println("Graph contains negative weight cycle");

        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i + "\t\t" + dist[i]);
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

        new day127_bellman_ford().bellmanFord(edges, V, 0);
    }
}

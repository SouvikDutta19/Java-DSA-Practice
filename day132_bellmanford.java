// day132_bellmanford.java
import java.util.*;

public class day132_bellmanford {
    class Edge {
        int src, dest, weight;
        Edge(int s, int d, int w) { src = s; dest = d; weight = w; }
    }

    void bellmanFord(int V, int E, List<Edge> edges, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int i = 1; i < V; i++)
            for (Edge e : edges)
                if (dist[e.src] != Integer.MAX_VALUE && dist[e.src] + e.weight < dist[e.dest])
                    dist[e.dest] = dist[e.src] + e.weight;

        for (Edge e : edges)
            if (dist[e.src] != Integer.MAX_VALUE && dist[e.src] + e.weight < dist[e.dest])
                System.out.println("Graph contains negative weight cycle");

        for (int i = 0; i < V; i++)
            System.out.println("Distance to " + i + " is " + dist[i]);
    }

    public static void main(String[] args) {
        day132_bellmanford bf = new day132_bellmanford();
        List<Edge> edges = new ArrayList<>();
        edges.add(bf.new Edge(0, 1, -1));
        edges.add(bf.new Edge(0, 2, 4));
        edges.add(bf.new Edge(1, 2, 3));
        edges.add(bf.new Edge(1, 3, 2));
        edges.add(bf.new Edge(1, 4, 2));
        edges.add(bf.new Edge(3, 2, 5));
        edges.add(bf.new Edge(3, 1, 1));
        edges.add(bf.new Edge(4, 3, -3));
        bf.bellmanFord(5, edges.size(), edges, 0);
    }
}

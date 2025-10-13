import java.util.*;

// Bellman-Ford algorithm to find shortest paths from a single source
public class day107_bellman_ford {
    static class Edge {
        int src, dest, weight;
        Edge(int s, int d, int w) { src = s; dest = d; weight = w; }
    }

    int V, E;
    Edge[] edges;

    day107_bellman_ford(int v, int e) {
        V = v;
        E = e;
        edges = new Edge[e];
    }

    void bellmanFord(int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int i = 1; i < V; ++i)
            for (int j = 0; j < E; ++j) {
                int u = edges[j].src;
                int v = edges[j].dest;
                int w = edges[j].weight;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v])
                    dist[v] = dist[u] + w;
            }

        for (int j = 0; j < E; ++j) {
            int u = edges[j].src, v = edges[j].dest, w = edges[j].weight;
            if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                System.out.println("Graph contains negative weight cycle!");
                return;
            }
        }

        System.out.println("Vertex Distance from Source:");
        for (int i = 0; i < V; ++i)
            System.out.println(i + "\t\t" + dist[i]);
    }

    public static void main(String[] args) {
        int V = 5, E = 8;
        day107_bellman_ford g = new day107_bellman_ford(V, E);
        g.edges[0] = new Edge(0, 1, -1);
        g.edges[1] = new Edge(0, 2, 4);
        g.edges[2] = new Edge(1, 2, 3);
        g.edges[3] = new Edge(1, 3, 2);
        g.edges[4] = new Edge(1, 4, 2);
        g.edges[5] = new Edge(3, 2, 5);
        g.edges[6] = new Edge(3, 1, 1);
        g.edges[7] = new Edge(4, 3, -3);
        g.bellmanFord(0);
    }
}

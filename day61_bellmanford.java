// Program to implement Bellman-Ford Algorithm for shortest paths
import java.util.*;

class Edge {
    int src, dest, weight;
    Edge(int s, int d, int w) { src = s; dest = d; weight = w; }
}

public class day61_bellmanford {
    int V, E;
    Edge[] edges;

    day61_bellmanford(int v, int e) {
        V = v; E = e;
        edges = new Edge[e];
    }

    void bellmanFord(int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int i = 1; i < V; i++) {
            for (int j = 0; j < E; j++) {
                int u = edges[j].src;
                int v = edges[j].dest;
                int w = edges[j].weight;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }

        for (int j = 0; j < E; j++) {
            int u = edges[j].src;
            int v = edges[j].dest;
            int w = edges[j].weight;
            if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                System.out.println("Graph contains negative weight cycle");
                return;
            }
        }

        System.out.println("Vertex distances from source:");
        for (int i = 0; i < V; i++)
            System.out.println(i + "\t" + dist[i]);
    }

    public static void main(String[] args) {
        int V = 5; int E = 8;
        day61_bellmanford graph = new day61_bellmanford(V, E);

        graph.edges[0] = new Edge(0, 1, -1);
        graph.edges[1] = new Edge(0, 2, 4);
        graph.edges[2] = new Edge(1, 2, 3);
        graph.edges[3] = new Edge(1, 3, 2);
        graph.edges[4] = new Edge(1, 4, 2);
        graph.edges[5] = new Edge(3, 2, 5);
        graph.edges[6] = new Edge(3, 1, 1);
        graph.edges[7] = new Edge(4, 3, -3);

        graph.bellmanFord(0);
    }
}

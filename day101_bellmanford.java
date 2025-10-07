import java.util.*;

public class day101_bellmanford {
    class Edge {
        int src, dest, weight;
        Edge(int s, int d, int w) { src = s; dest = d; weight = w; }
    }

    int V, E;
    Edge edge[];

    day101_bellmanford(int v, int e) {
        V = v; E = e; edge = new Edge[e];
        for (int i = 0; i < e; ++i)
            edge[i] = new Edge(0, 0, 0);
    }

    void BellmanFord(int src) {
        int dist[] = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int i = 1; i < V; ++i)
            for (int j = 0; j < E; ++j) {
                int u = edge[j].src, v = edge[j].dest, w = edge[j].weight;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v])
                    dist[v] = dist[u] + w;
            }

        for (int j = 0; j < E; ++j) {
            int u = edge[j].src, v = edge[j].dest, w = edge[j].weight;
            if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                System.out.println("Graph contains negative weight cycle");
                return;
            }
        }

        printArr(dist, V);
    }

    void printArr(int dist[], int V) {
        System.out.println("Vertex Distance from Source:");
        for (int i = 0; i < V; ++i)
            System.out.println(i + "\t" + dist[i]);
    }

    public static void main(String[] args) {
        int V = 5, E = 8;
        day101_bellmanford graph = new day101_bellmanford(V, E);

        graph.edge[0] = graph.new Edge(0, 1, -1);
        graph.edge[1] = graph.new Edge(0, 2, 4);
        graph.edge[2] = graph.new Edge(1, 2, 3);
        graph.edge[3] = graph.new Edge(1, 3, 2);
        graph.edge[4] = graph.new Edge(1, 4, 2);
        graph.edge[5] = graph.new Edge(3, 2, 5);
        graph.edge[6] = graph.new Edge(3, 1, 1);
        graph.edge[7] = graph.new Edge(4, 3, -3);

        graph.BellmanFord(0);
    }
}

public class day130_bellman_ford_algorithm {

    static class Edge {
        int src, dest, weight;
        Edge() { src = dest = weight = 0; }
    }

    int V, E;
    Edge[] edge;

    day130_bellman_ford_algorithm(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[e];
        for (int i = 0; i < e; ++i)
            edge[i] = new Edge();
    }

    void bellmanFord(int src) {
        int[] dist = new int[V];
        for (int i = 0; i < V; ++i)
            dist[i] = Integer.MAX_VALUE;
        dist[src] = 0;

        for (int i = 1; i < V; ++i) {
            for (int j = 0; j < E; ++j) {
                int u = edge[j].src;
                int v = edge[j].dest;
                int weight = edge[j].weight;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v])
                    dist[v] = dist[u] + weight;
            }
        }

        for (int j = 0; j < E; ++j) {
            int u = edge[j].src;
            int v = edge[j].dest;
            int weight = edge[j].weight;
            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v])
                System.out.println("Graph contains negative weight cycle");
        }
        printArr(dist);
    }

    void printArr(int[] dist) {
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < V; ++i)
            System.out.println(i + "\t\t" + dist[i]);
    }

    public static void main(String[] args) {
        int V = 5, E = 8;
        day130_bellman_ford_algorithm g = new day130_bellman_ford_algorithm(V, E);

        g.edge[0].src = 0; g.edge[0].dest = 1; g.edge[0].weight = -1;
        g.edge[1].src = 0; g.edge[1].dest = 2; g.edge[1].weight = 4;
        g.edge[2].src = 1; g.edge[2].dest = 2; g.edge[2].weight = 3;
        g.edge[3].src = 1; g.edge[3].dest = 3; g.edge[3].weight = 2;
        g.edge[4].src = 1; g.edge[4].dest = 4; g.edge[4].weight = 2;
        g.edge[5].src = 3; g.edge[5].dest = 2; g.edge[5].weight = 5;
        g.edge[6].src = 3; g.edge[6].dest = 1; g.edge[6].weight = 1;
        g.edge[7].src = 4; g.edge[7].dest = 3; g.edge[7].weight = -3;

        g.bellmanFord(0);
    }
}

import java.util.*;

public class day40_weighted_graph_dijkstra {
    static class Edge {
        int dest, weight;
        Edge(int d, int w) {
            dest = d;
            weight = w;
        }
    }

    static class Graph {
        int V;
        LinkedList<Edge>[] adj;

        Graph(int v) {
            V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; i++)
                adj[i] = new LinkedList<>();
        }

        void addEdge(int src, int dest, int weight) {
            adj[src].add(new Edge(dest, weight));
            adj[dest].add(new Edge(src, weight));
        }

        void dijkstra(int src) {
            PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
            int[] dist = new int[V];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[src] = 0;
            pq.add(new Edge(src, 0));

            while (!pq.isEmpty()) {
                Edge node = pq.poll();
                for (Edge e : adj[node.dest]) {
                    if (dist[node.dest] + e.weight < dist[e.dest]) {
                        dist[e.dest] = dist[node.dest] + e.weight;
                        pq.add(new Edge(e.dest, dist[e.dest]));
                    }
                }
            }

            System.out.println("Vertex Distance from Source:");
            for (int i = 0; i < V; i++)
                System.out.println(i + " \t " + dist[i]);
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(0, 1, 4);
        g.addEdge(0, 2, 2);
        g.addEdge(1, 2, 5);
        g.addEdge(1, 3, 10);
        g.addEdge(2, 4, 3);
        g.addEdge(4, 3, 4);
        g.addEdge(3, 5, 11);

        g.dijkstra(0);
    }
}

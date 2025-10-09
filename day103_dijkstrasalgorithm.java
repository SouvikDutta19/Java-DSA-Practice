import java.util.*;

class GraphNode implements Comparable<GraphNode> {
    int vertex, distance;
    GraphNode(int v, int d) {
        vertex = v;
        distance = d;
    }
    public int compareTo(GraphNode o) {
        return this.distance - o.distance;
    }
}

public class day103_dijkstrasalgorithm {
    public static void dijkstra(List<List<GraphNode>> graph, int src) {
        int V = graph.size();
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<GraphNode> pq = new PriorityQueue<>();
        pq.add(new GraphNode(src, 0));

        while (!pq.isEmpty()) {
            int u = pq.poll().vertex;
            for (GraphNode neighbor : graph.get(u)) {
                int v = neighbor.vertex;
                int weight = neighbor.distance;
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new GraphNode(v, dist[v]));
                }
            }
        }

        System.out.println("Shortest distances from source " + src + ":");
        for (int i = 0; i < V; i++)
            System.out.println(i + " -> " + dist[i]);
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<GraphNode>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++)
            graph.add(new ArrayList<>());

        graph.get(0).add(new GraphNode(1, 9));
        graph.get(0).add(new GraphNode(2, 6));
        graph.get(0).add(new GraphNode(3, 5));
        graph.get(0).add(new GraphNode(4, 3));
        graph.get(2).add(new GraphNode(1, 2));
        graph.get(2).add(new GraphNode(3, 4));

        dijkstra(graph, 0);
    }
}

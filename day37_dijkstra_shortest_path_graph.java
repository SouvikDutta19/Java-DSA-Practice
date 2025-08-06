import java.util.*;

class GraphNode {
    int vertex, weight;
    GraphNode(int v, int w) {
        vertex = v;
        weight = w;
    }
}

public class day37_dijkstra_shortest_path_graph {

    public static void dijkstra(List<List<GraphNode>> graph, int src) {
        int V = graph.size();
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<GraphNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));
        pq.add(new GraphNode(src, 0));

        while (!pq.isEmpty()) {
            GraphNode curr = pq.poll();
            for (GraphNode neighbor : graph.get(curr.vertex)) {
                if (dist[neighbor.vertex] > dist[curr.vertex] + neighbor.weight) {
                    dist[neighbor.vertex] = dist[curr.vertex] + neighbor.weight;
                    pq.add(new GraphNode(neighbor.vertex, dist[neighbor.vertex]));
                }
            }
        }

        System.out.println("Shortest distances from node " + src + ":");
        for (int i = 0; i < V; i++) {
            System.out.println("To " + i + " = " + dist[i]);
        }
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<GraphNode>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());

        graph.get(0).add(new GraphNode(1, 4));
        graph.get(0).add(new GraphNode(2, 1));
        graph.get(2).add(new GraphNode(1, 2));
        graph.get(1).add(new GraphNode(3, 1));
        graph.get(2).add(new GraphNode(3, 5));
        graph.get(3).add(new GraphNode(4, 3));

        dijkstra(graph, 0);
    }
}

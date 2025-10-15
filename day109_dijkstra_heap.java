import java.util.*;

// Dijkstra’s Algorithm using Priority Queue (Min Heap)
public class day109_dijkstra_heap {
    static class Node implements Comparable<Node> {
        int vertex, dist;
        Node(int v, int d) { vertex = v; dist = d; }
        public int compareTo(Node other) {
            return Integer.compare(this.dist, other.dist);
        }
    }

    void dijkstra(List<List<Node>> graph, int src, int V) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        pq.add(new Node(src, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            for (Node neighbor : graph.get(node.vertex)) {
                int newDist = dist[node.vertex] + neighbor.dist;
                if (newDist < dist[neighbor.vertex]) {
                    dist[neighbor.vertex] = newDist;
                    pq.add(new Node(neighbor.vertex, newDist));
                }
            }
        }

        System.out.println("Shortest distances from source " + src + ":");
        for (int i = 0; i < V; i++)
            System.out.println("Vertex " + i + " -> Distance: " + dist[i]);
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++)
            graph.add(new ArrayList<>());

        graph.get(0).add(new Node(1, 9));
        graph.get(0).add(new Node(2, 6));
        graph.get(0).add(new Node(3, 5));
        graph.get(0).add(new Node(4, 3));
        graph.get(2).add(new Node(1, 2));
        graph.get(2).add(new Node(3, 4));

        new day109_dijkstra_heap().dijkstra(graph, 0, V);
    }
}

// day131_dijkstrashortestpath.java
import java.util.*;

public class day131_dijkstrashortestpath {
    static class Node implements Comparator<Node> {
        int node, cost;
        Node() {}
        Node(int node, int cost) { this.node = node; this.cost = cost; }
        public int compare(Node a, Node b) { return a.cost - b.cost; }
    }

    public void dijkstra(List<List<Node>> graph, int src, int V) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(V, new Node());
        pq.add(new Node(src, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            for (Node adj : graph.get(node.node)) {
                if (dist[node.node] + adj.cost < dist[adj.node]) {
                    dist[adj.node] = dist[node.node] + adj.cost;
                    pq.add(new Node(adj.node, dist[adj.node]));
                }
            }
        }

        for (int i = 0; i < V; i++)
            System.out.println("Distance from " + src + " to " + i + " is " + dist[i]);
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());
        graph.get(0).add(new Node(1, 9));
        graph.get(0).add(new Node(2, 6));
        graph.get(0).add(new Node(3, 5));
        graph.get(0).add(new Node(4, 3));
        graph.get(2).add(new Node(1, 2));
        graph.get(2).add(new Node(3, 4));
        new day131_dijkstrashortestpath().dijkstra(graph, 0, V);
    }
}

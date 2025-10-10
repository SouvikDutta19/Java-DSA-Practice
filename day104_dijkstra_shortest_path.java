import java.util.*;

// Dijkstra’s Algorithm for shortest path
class Node implements Comparable<Node> {
    int v, w;
    Node(int v, int w) { this.v = v; this.w = w; }
    public int compareTo(Node o) { return this.w - o.w; }
}

public class day104_dijkstra_shortest_path {
    public static void dijkstra(int V, List<List<Node>> adj, int src) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        pq.add(new Node(src, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            for (Node n : adj.get(curr.v)) {
                if (dist[curr.v] + n.w < dist[n.v]) {
                    dist[n.v] = dist[curr.v] + n.w;
                    pq.add(new Node(n.v, dist[n.v]));
                }
            }
        }

        System.out.println("Shortest distances from source:");
        for (int i = 0; i < V; i++)
            System.out.println("Node " + i + ": " + dist[i]);
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Node>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        adj.get(0).add(new Node(1, 9));
        adj.get(0).add(new Node(2, 6));
        adj.get(0).add(new Node(3, 5));
        adj.get(0).add(new Node(4, 3));
        adj.get(2).add(new Node(1, 2));
        adj.get(2).add(new Node(3, 4));

        dijkstra(V, adj, 0);
    }
}

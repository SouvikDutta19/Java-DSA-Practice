import java.util.*;

public class day127_dijkstra_algorithm {

    static class Node implements Comparator<Node> {
        int vertex, weight;
        Node() {}
        Node(int v, int w) { vertex = v; weight = w; }

        public int compare(Node a, Node b) {
            return a.weight - b.weight;
        }
    }

    void dijkstra(int V, List<List<Node>> adj, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(V, new Node());
        pq.add(new Node(src, 0));

        while (!pq.isEmpty()) {
            int u = pq.poll().vertex;
            for (Node node : adj.get(u)) {
                int v = node.vertex;
                int weight = node.weight;

                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new Node(v, dist[v]));
                }
            }
        }

        System.out.println("Vertex \t Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i + " \t\t " + dist[i]);
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Node>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        adj.get(0).add(new Node(1, 9));
        adj.get(0).add(new Node(2, 6));
        adj.get(0).add(new Node(3, 5));
        adj.get(0).add(new Node(4, 3));
        adj.get(2).add(new Node(1, 2));
        adj.get(2).add(new Node(3, 4));

        new day127_dijkstra_algorithm().dijkstra(V, adj, 0);
    }
}

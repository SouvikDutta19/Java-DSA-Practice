import java.util.*;

class Pair {
    int node, weight;
    Pair(int n, int w) { node = n; weight = w; }
}

public class day124_dijkstra_algorithm {
    static void dijkstra(int V, List<List<Pair>> adj, int src) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.weight-b.weight);
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int node = p.node, weight = p.weight;
            for (Pair neighbor : adj.get(node)) {
                if (dist[node] + neighbor.weight < dist[neighbor.node]) {
                    dist[neighbor.node] = dist[node] + neighbor.weight;
                    pq.add(new Pair(neighbor.node, dist[neighbor.node]));
                }
            }
        }

        System.out.println("Shortest distances:");
        for (int i = 0; i < V; i++)
            System.out.println(i + " -> " + dist[i]);
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        adj.get(0).add(new Pair(1, 9));
        adj.get(0).add(new Pair(2, 6));
        adj.get(0).add(new Pair(3, 5));
        adj.get(0).add(new Pair(4, 3));
        adj.get(2).add(new Pair(1, 2));
        adj.get(2).add(new Pair(3, 4));

        dijkstra(V, adj, 0);
    }
}

import java.util.*;

public class day21_dijkstra_shortest_path {
    static class Pair implements Comparable<Pair> {
        int node, dist;
        Pair(int n, int d) { node = n; dist = d; }
        public int compareTo(Pair other) { return this.dist - other.dist; }
    }

    public static void dijkstra(List<List<Pair>> adj, int src, int V) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int u = p.node;
            for (Pair neighbor : adj.get(u)) {
                int v = neighbor.node, weight = neighbor.dist;
                if (dist[v] > dist[u] + weight) {
                    dist[v] = dist[u] + weight;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }

        for (int i = 0; i < V; i++)
            System.out.println("Distance from " + src + " to " + i + " = " + dist[i]);
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

        dijkstra(adj, 0, V);
    }
}

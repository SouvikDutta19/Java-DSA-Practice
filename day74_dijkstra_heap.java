import java.util.*;

public class day74_dijkstra_heap {
    static class Pair {
        int v, w;
        Pair(int v, int w) { this.v = v; this.w = w; }
    }

    static void dijkstra(List<List<Pair>> adj, int src) {
        int n = adj.size();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.w));
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int u = cur.v;
            for (Pair p : adj.get(u)) {
                if (dist[u] + p.w < dist[p.v]) {
                    dist[p.v] = dist[u] + p.w;
                    pq.add(new Pair(p.v, dist[p.v]));
                }
            }
        }

        System.out.println("Shortest distances from source " + src);
        for (int i = 0; i < n; i++) System.out.println(i + " -> " + dist[i]);
    }

    public static void main(String[] args) {
        int n = 5;
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        adj.get(0).add(new Pair(1, 9));
        adj.get(0).add(new Pair(2, 6));
        adj.get(0).add(new Pair(3, 5));
        adj.get(0).add(new Pair(4, 3));
        adj.get(2).add(new Pair(1, 2));
        adj.get(2).add(new Pair(3, 4));

        dijkstra(adj, 0);
    }
}

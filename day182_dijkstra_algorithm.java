import java.util.*;

public class day182_dijkstra_algorithm {

    static class Pair {
        int node, dist;
        Pair(int n, int d) { node = n; dist = d; }
    }

    public static void dijkstra(int V, List<List<Pair>> g, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.dist));
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            for (Pair nbr : g.get(p.node)) {
                if (dist[p.node] + nbr.dist < dist[nbr.node]) {
                    dist[nbr.node] = dist[p.node] + nbr.dist;
                    pq.add(new Pair(nbr.node, dist[nbr.node]));
                }
            }
        }

        for (int i = 0; i < V; i++)
            System.out.println(src + " -> " + i + " = " + dist[i]);
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Pair>> g = new ArrayList<>();
        for (int i = 0; i < V; i++) g.add(new ArrayList<>());

        g.get(0).add(new Pair(1, 2));
        g.get(0).add(new Pair(2, 4));
        g.get(1).add(new Pair(2, 1));
        g.get(1).add(new Pair(3, 7));
        g.get(2).add(new Pair(4, 3));

        dijkstra(V, g, 0);
    }
}
import java.util.*;

public class day166_dijkstra_shortest_path {

    static class Pair {
        int node, dist;

        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public static void dijkstra(int V, List<List<Pair>> graph, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Pair> pq =
                new PriorityQueue<>(Comparator.comparingInt(a -> a.dist));
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int u = curr.node;

            for (Pair nei : graph.get(u)) {
                if (dist[u] + nei.dist < dist[nei.node]) {
                    dist[nei.node] = dist[u] + nei.dist;
                    pq.add(new Pair(nei.node, dist[nei.node]));
                }
            }
        }

        System.out.println("Shortest distances from source:");
        for (int i = 0; i < V; i++)
            System.out.println(i + " -> " + dist[i]);
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());

        graph.get(0).add(new Pair(1, 4));
        graph.get(0).add(new Pair(2, 1));
        graph.get(2).add(new Pair(1, 2));
        graph.get(1).add(new Pair(3, 1));
        graph.get(2).add(new Pair(3, 5));
        graph.get(3).add(new Pair(4, 3));

        dijkstra(V, graph, 0);
    }
}
import java.util.*;

public class day160_dijkstra_algorithm {

    static class Edge {
        int v, w;
        Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    static void dijkstra(List<List<Edge>> graph, int src) {
        int n = graph.size();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[] { src, 0 });

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0];

            for (Edge e : graph.get(u)) {
                if (dist[u] + e.w < dist[e.v]) {
                    dist[e.v] = dist[u] + e.w;
                    pq.offer(new int[] { e.v, dist[e.v] });
                }
            }
        }

        System.out.println("Shortest distances from source:");
        for (int i = 0; i < n; i++) {
            System.out.println(i + " -> " + dist[i]);
        }
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Edge>> g = new ArrayList<>();

        for (int i = 0; i < V; i++) g.add(new ArrayList<>());

        g.get(0).add(new Edge(1, 9));
        g.get(0).add(new Edge(2, 6));
        g.get(0).add(new Edge(3, 5));
        g.get(0).add(new Edge(4, 3));

        dijkstra(g, 0);
    }
}
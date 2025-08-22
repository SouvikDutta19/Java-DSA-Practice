import java.util.*;

class Edge {
    int v, w;
    Edge(int v, int w) { this.v = v; this.w = w; }
}

public class day53_dijkstra_path {
    public static void dijkstra(List<Edge>[] graph, int src) {
        int n = graph.length;
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{src, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0];
            int d = cur[1];

            if (d > dist[u]) continue;

            for (Edge e : graph[u]) {
                if (dist[u] + e.w < dist[e.v]) {
                    dist[e.v] = dist[u] + e.w;
                    pq.add(new int[]{e.v, dist[e.v]});
                }
            }
        }

        System.out.println("Shortest Distances from " + src + ": " + Arrays.toString(dist));
    }

    public static void main(String[] args) {
        int V = 5;
        List<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) graph[i] = new ArrayList<>();

        graph[0].add(new Edge(1, 9));
        graph[0].add(new Edge(2, 6));
        graph[0].add(new Edge(3, 5));
        graph[0].add(new Edge(4, 3));
        graph[2].add(new Edge(1, 2));
        graph[2].add(new Edge(3, 4));

        dijkstra(graph, 0);
    }
}

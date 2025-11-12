import java.util.*;

public class day136_shortest_path_dijkstra {
    static class Edge {
        int dest, weight;
        Edge(int d, int w) { dest = d; weight = w; }
    }

    static void dijkstra(Map<Integer, List<Edge>> graph, int source, int vertices) {
        int[] dist = new int[vertices];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{source, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0], d = cur[1];

            if (d > dist[u]) continue;
            for (Edge e : graph.getOrDefault(u, new ArrayList<>())) {
                int newDist = dist[u] + e.weight;
                if (newDist < dist[e.dest]) {
                    dist[e.dest] = newDist;
                    pq.offer(new int[]{e.dest, newDist});
                }
            }
        }

        System.out.println("Shortest distances from source:");
        for (int i = 0; i < vertices; i++)
            System.out.println(i + " -> " + dist[i]);
    }

    public static void main(String[] args) {
        Map<Integer, List<Edge>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(new Edge(1, 4), new Edge(2, 1)));
        graph.put(2, Arrays.asList(new Edge(1, 2), new Edge(3, 5)));
        graph.put(1, Arrays.asList(new Edge(3, 1)));

        dijkstra(graph, 0, 4);
    }
}

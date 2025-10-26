import java.util.*;

public class day119_dijkstra_algorithm {
    static class Edge {
        int dest, weight;
        Edge(int d, int w) { dest = d; weight = w; }
    }

    static void dijkstra(List<List<Edge>> graph, int src, int V) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{src, 0});

        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int u = node[0], d = node[1];
            if (d > dist[u]) continue;

            for (Edge e : graph.get(u)) {
                if (dist[u] + e.weight < dist[e.dest]) {
                    dist[e.dest] = dist[u] + e.weight;
                    pq.offer(new int[]{e.dest, dist[e.dest]});
                }
            }
        }

        System.out.println("Vertex \t Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i + "\t\t" + dist[i]);
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());

        graph.get(0).add(new Edge(1, 9));
        graph.get(0).add(new Edge(2, 6));
        graph.get(0).add(new Edge(3, 5));
        graph.get(0).add(new Edge(4, 3));
        graph.get(2).add(new Edge(1, 2));
        graph.get(2).add(new Edge(3, 4));

        dijkstra(graph, 0, V);
    }
}

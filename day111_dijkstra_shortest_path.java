// Program to find the shortest path using Dijkstra's Algorithm

import java.util.*;

class Edge {
    int dest, weight;
    Edge(int d, int w) { dest = d; weight = w; }
}

public class day111_dijkstra_shortest_path {
    public static void dijkstra(Map<Integer, List<Edge>> graph, int src, int V) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{src, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];
            for (Edge e : graph.getOrDefault(u, new ArrayList<>())) {
                int v = e.dest;
                int weight = e.weight;
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new int[]{v, dist[v]});
                }
            }
        }

        System.out.println("Vertex\tDistance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i + "\t" + dist[i]);
    }

    public static void main(String[] args) {
        int V = 5;
        Map<Integer, List<Edge>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(new Edge(1, 9), new Edge(2, 6), new Edge(3, 5), new Edge(4, 3)));
        graph.put(2, Arrays.asList(new Edge(1, 2), new Edge(3, 4)));

        dijkstra(graph, 0, V);
    }
}

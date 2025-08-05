import java.util.*;

public class day36_dijkstrasshortestpath {
    static class Pair {
        int vertex, weight;

        Pair(int v, int w) {
            vertex = v;
            weight = w;
        }
    }

    static void dijkstra(List<List<Pair>> graph, int src, int V) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.weight));
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int u = curr.vertex;

            for (Pair neighbor : graph.get(u)) {
                int v = neighbor.vertex, weight = neighbor.weight;

                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }

        System.out.println("Shortest distances from source:");
        for (int i = 0; i < V; i++) {
            System.out.println("To " + i + " = " + dist[i]);
        }
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());

        graph.get(0).add(new Pair(1, 9));
        graph.get(0).add(new Pair(2, 6));
        graph.get(0).add(new Pair(3, 5));
        graph.get(0).add(new Pair(4, 3));
        graph.get(2).add(new Pair(1, 2));
        graph.get(2).add(new Pair(3, 4));

        dijkstra(graph, 0, V);
    }
}

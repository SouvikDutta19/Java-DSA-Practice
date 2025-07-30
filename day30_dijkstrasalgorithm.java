import java.util.*;

class Pair implements Comparable<Pair> {
    int vertex, dist;
    Pair(int v, int d) {
        vertex = v;
        dist = d;
    }

    public int compareTo(Pair that) {
        return this.dist - that.dist;
    }
}

public class day30_dijkstrasalgorithm {
    public static void dijkstra(List<List<Pair>> graph, int src, int V) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            for (Pair neighbor : graph.get(curr.vertex)) {
                if (dist[curr.vertex] + neighbor.dist < dist[neighbor.vertex]) {
                    dist[neighbor.vertex] = dist[curr.vertex] + neighbor.dist;
                    pq.add(new Pair(neighbor.vertex, dist[neighbor.vertex]));
                }
            }
        }

        System.out.println("Shortest distances from source:");
        for (int i = 0; i < V; i++)
            System.out.println("To " + i + " -> " + dist[i]);
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

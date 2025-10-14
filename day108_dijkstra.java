import java.util.*;

// Dijkstra's Algorithm for Shortest Path
public class day108_dijkstra {
    static class Pair implements Comparable<Pair> {
        int node, dist;
        Pair(int n, int d) { node = n; dist = d; }
        public int compareTo(Pair p) { return this.dist - p.dist; }
    }

    public static void dijkstra(List<List<Pair>> graph, int src) {
        int V = graph.size();
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            int u = pq.poll().node;
            for (Pair p : graph.get(u)) {
                if (dist[u] + p.dist < dist[p.node]) {
                    dist[p.node] = dist[u] + p.dist;
                    pq.add(new Pair(p.node, dist[p.node]));
                }
            }
        }

        System.out.println("Shortest distances from source " + src + ":");
        for (int i = 0; i < V; i++)
            System.out.println(i + " → " + dist[i]);
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
        dijkstra(graph, 0);
    }
}

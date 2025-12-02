import java.util.*;

public class day152_dijkstra {

    static class Node {
        int v, dist;
        Node(int v, int d) { this.v = v; this.dist = d; }
    }

    public static void dijkstra(List<List<Node>> graph, int src) {
        int V = graph.size();
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.dist));

        dist[src] = 0;
        pq.add(new Node(src, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            for (Node neigh : graph.get(cur.v)) {
                if (dist[cur.v] + neigh.dist < dist[neigh.v]) {
                    dist[neigh.v] = dist[cur.v] + neigh.dist;
                    pq.add(new Node(neigh.v, dist[neigh.v]));
                }
            }
        }

        System.out.println("Shortest distances from node " + src + ":");
        System.out.println(Arrays.toString(dist));
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());

        graph.get(0).add(new Node(1, 9));
        graph.get(0).add(new Node(2, 6));
        graph.get(0).add(new Node(3, 5));
        graph.get(0).add(new Node(4, 3));

        graph.get(2).add(new Node(1, 2));
        graph.get(2).add(new Node(3, 4));

        dijkstra(graph, 0);
    }
}

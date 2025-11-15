// day138_dijkstras_shortest_path.java
import java.util.*;

public class day138_dijkstras_shortest_path {

    static class Node implements Comparable<Node> {
        int vertex, weight;
        Node(int v, int w) { vertex = v; weight = w; }
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    public static int[] dijkstra(List<List<Node>> graph, int src) {
        int n = graph.size();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(src, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            for (Node next : graph.get(curr.vertex)) {
                if (dist[curr.vertex] + next.weight < dist[next.vertex]) {
                    dist[next.vertex] = dist[curr.vertex] + next.weight;
                    pq.add(new Node(next.vertex, dist[next.vertex]));
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < 5; i++) graph.add(new ArrayList<>());
        
        graph.get(0).add(new Node(1, 2));
        graph.get(0).add(new Node(2, 4));
        graph.get(1).add(new Node(2, 1));
        graph.get(1).add(new Node(3, 7));
        graph.get(2).add(new Node(4, 3));

        int[] res = dijkstra(graph, 0);
        System.out.println("Shortest distances from node 0:");
        System.out.println(Arrays.toString(res));
    }
}

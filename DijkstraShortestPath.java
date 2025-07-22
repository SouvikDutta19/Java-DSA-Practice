import java.util.*;

class Node implements Comparable<Node> {
    int vertex, dist;
    Node(int v, int d) {
        vertex = v;
        dist = d;
    }
    public int compareTo(Node o) {
        return Integer.compare(this.dist, o.dist);
    }
}

public class DijkstraShortestPath {
    static void dijkstra(List<List<Node>> graph, int src) {
        int V = graph.size();
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(src, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            for (Node neighbor : graph.get(curr.vertex)) {
                if (dist[neighbor.vertex] > dist[curr.vertex] + neighbor.dist) {
                    dist[neighbor.vertex] = dist[curr.vertex] + neighbor.dist;
                    pq.offer(new Node(neighbor.vertex, dist[neighbor.vertex]));
                }
            }
        }

        for (int i = 0; i < V; i++)
            System.out.println("Distance from " + src + " to " + i + ": " + dist[i]);
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

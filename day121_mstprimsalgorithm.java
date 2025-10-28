// day121_mstprimsalgorithm.java
import java.util.*;

public class day121_mstprimsalgorithm {
    static class Node implements Comparable<Node> {
        int vertex, weight;
        Node(int v, int w) { this.vertex = v; this.weight = w; }
        public int compareTo(Node o) { return this.weight - o.weight; }
    }

    public static void prims(int V, List<List<Node>> adj) {
        boolean[] inMST = new boolean[V];
        int[] key = new int[V];
        int[] parent = new int[V];
        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        key[0] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0));

        while (!pq.isEmpty()) {
            int u = pq.poll().vertex;
            inMST[u] = true;

            for (Node v : adj.get(u)) {
                if (!inMST[v.vertex] && v.weight < key[v.vertex]) {
                    parent[v.vertex] = u;
                    key[v.vertex] = v.weight;
                    pq.add(new Node(v.vertex, key[v.vertex]));
                }
            }
        }

        System.out.println("Edges in MST:");
        for (int i = 1; i < V; i++)
            System.out.println(parent[i] + " - " + i);
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Node>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        adj.get(0).add(new Node(1, 2));
        adj.get(0).add(new Node(3, 6));
        adj.get(1).add(new Node(2, 3));
        adj.get(1).add(new Node(3, 8));
        adj.get(1).add(new Node(4, 5));
        adj.get(2).add(new Node(4, 7));

        prims(V, adj);
    }
}

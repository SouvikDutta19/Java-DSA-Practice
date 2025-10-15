import java.util.*;

// Prim's Algorithm for Minimum Spanning Tree using PriorityQueue
public class day109_minimum_spanning_tree_prim {
    static class Node implements Comparable<Node> {
        int vertex, key;
        Node(int v, int k) { vertex = v; key = k; }
        public int compareTo(Node other) {
            return this.key - other.key;
        }
    }

    void primMST(int[][] graph, int V) {
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

            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && !inMST[v] && graph[u][v] < key[v]) {
                    key[v] = graph[u][v];
                    pq.add(new Node(v, key[v]));
                    parent[v] = u;
                }
            }
        }

        System.out.println("Edge \tWeight");
        for (int i = 1; i < V; i++)
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 2, 0, 6, 0},
            {2, 0, 3, 8, 5},
            {0, 3, 0, 0, 7},
            {6, 8, 0, 0, 9},
            {0, 5, 7, 9, 0}
        };
        new day109_minimum_spanning_tree_prim().primMST(graph, 5);
    }
}

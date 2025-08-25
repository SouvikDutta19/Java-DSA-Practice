import java.util.*;

public class day56_prims_mst {
    static class Edge {
        int vertex, weight;
        Edge(int v, int w) {
            vertex = v;
            weight = w;
        }
    }

    static void primMST(int V, List<List<Edge>> graph) {
        boolean[] inMST = new boolean[V];
        int[] key = new int[V];
        int[] parent = new int[V];
        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;
        parent[0] = -1;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{0, 0});

        while (!pq.isEmpty()) {
            int u = pq.poll()[0];
            inMST[u] = true;
            for (Edge edge : graph.get(u)) {
                if (!inMST[edge.vertex] && edge.weight < key[edge.vertex]) {
                    key[edge.vertex] = edge.weight;
                    parent[edge.vertex] = u;
                    pq.add(new int[]{edge.vertex, key[edge.vertex]});
                }
            }
        }

        System.out.println("Edges in MST using Prim's Algorithm:");
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i + " : " + key[i]);
        }
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());

        graph.get(0).add(new Edge(1, 2));
        graph.get(0).add(new Edge(3, 6));
        graph.get(1).add(new Edge(0, 2));
        graph.get(1).add(new Edge(2, 3));
        graph.get(1).add(new Edge(3, 8));
        graph.get(1).add(new Edge(4, 5));
        graph.get(2).add(new Edge(1, 3));
        graph.get(2).add(new Edge(4, 7));
        graph.get(3).add(new Edge(0, 6));
        graph.get(3).add(new Edge(1, 8));
        graph.get(4).add(new Edge(1, 5));
        graph.get(4).add(new Edge(2, 7));

        primMST(V, graph);
    }
}

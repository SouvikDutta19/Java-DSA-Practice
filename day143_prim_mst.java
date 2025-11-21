import java.util.*;

class Pair {
    int vertex;
    int weight;
    Pair(int v, int w) {
        vertex = v;
        weight = w;
    }
}

public class day143_prim_mst {

    public static void primMST(List<List<Pair>> graph, int n) {
        boolean[] visited = new boolean[n];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);

        pq.offer(new Pair(0, 0));
        int totalWeight = 0;

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int u = cur.vertex;

            if (visited[u]) continue;

            visited[u] = true;
            totalWeight += cur.weight;

            for (Pair neigh : graph.get(u)) {
                if (!visited[neigh.vertex]) {
                    pq.offer(new Pair(neigh.vertex, neigh.weight));
                }
            }
        }

        System.out.println("Total Weight of Prim MST: " + totalWeight);
    }

    public static void main(String[] args) {

        int n = 5;
        List<List<Pair>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        graph.get(0).add(new Pair(1, 2));
        graph.get(0).add(new Pair(3, 6));
        graph.get(1).add(new Pair(0, 2));
        graph.get(1).add(new Pair(2, 3));
        graph.get(1).add(new Pair(3, 8));
        graph.get(1).add(new Pair(4, 5));
        graph.get(2).add(new Pair(1, 3));
        graph.get(2).add(new Pair(4, 7));
        graph.get(3).add(new Pair(0, 6));
        graph.get(3).add(new Pair(1, 8));
        graph.get(4).add(new Pair(1, 5));
        graph.get(4).add(new Pair(2, 7));

        primMST(graph, n);
    }
}

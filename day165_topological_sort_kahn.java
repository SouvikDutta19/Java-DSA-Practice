import java.util.*;

public class day165_topological_sort_kahn {

    public static void topologicalSort(int V, List<List<Integer>> graph) {
        int[] indegree = new int[V];

        for (int u = 0; u < V; u++) {
            for (int v : graph.get(u)) {
                indegree[v]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0)
                queue.add(i);
        }

        List<Integer> topo = new ArrayList<>();

        while (!queue.isEmpty()) {
            int u = queue.poll();
            topo.add(u);

            for (int v : graph.get(u)) {
                if (--indegree[v] == 0)
                    queue.add(v);
            }
        }

        if (topo.size() != V) {
            System.out.println("Cycle detected! Topological sort not possible.");
            return;
        }

        System.out.println("Topological Order:");
        for (int node : topo)
            System.out.print(node + " ");
    }

    public static void main(String[] args) {
        int V = 6;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());

        graph.get(5).add(2);
        graph.get(5).add(0);
        graph.get(4).add(0);
        graph.get(4).add(1);
        graph.get(2).add(3);
        graph.get(3).add(1);

        topologicalSort(V, graph);
    }
}
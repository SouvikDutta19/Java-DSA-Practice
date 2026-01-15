import java.util.*;

public class day178_topological_sort_kahns {

    public static void topologicalSort(int V, List<List<Integer>> graph) {
        int[] indegree = new int[V];

        for (int i = 0; i < V; i++)
            for (int v : graph.get(i))
                indegree[v]++;

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++)
            if (indegree[i] == 0)
                q.add(i);

        List<Integer> order = new ArrayList<>();

        while (!q.isEmpty()) {
            int u = q.poll();
            order.add(u);

            for (int v : graph.get(u)) {
                if (--indegree[v] == 0)
                    q.add(v);
            }
        }

        if (order.size() != V)
            System.out.println("Cycle detected. Topological sort not possible.");
        else
            System.out.println("Topological Order: " + order);
    }

    public static void main(String[] args) {
        int V = 6;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++)
            graph.add(new ArrayList<>());

        graph.get(5).add(2);
        graph.get(5).add(0);
        graph.get(4).add(0);
        graph.get(4).add(1);
        graph.get(2).add(3);
        graph.get(3).add(1);

        topologicalSort(V, graph);
    }
}
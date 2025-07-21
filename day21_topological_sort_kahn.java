import java.util.*;

public class day21_topological_sort_kahn {
    public static void topologicalSort(int V, List<Integer>[] graph) {
        int[] inDegree = new int[V];
        for (int u = 0; u < V; u++)
            for (int v : graph[u])
                inDegree[v]++;

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++)
            if (inDegree[i] == 0)
                queue.add(i);

        List<Integer> topo = new ArrayList<>();
        while (!queue.isEmpty()) {
            int u = queue.poll();
            topo.add(u);

            for (int v : graph[u]) {
                inDegree[v]--;
                if (inDegree[v] == 0)
                    queue.add(v);
            }
        }

        System.out.println("Topological Sort: " + topo);
    }

    public static void main(String[] args) {
        int V = 6;
        List<Integer>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) graph[i] = new ArrayList<>();

        graph[5].add(2);
        graph[5].add(0);
        graph[4].add(0);
        graph[4].add(1);
        graph[2].add(3);
        graph[3].add(1);

        topologicalSort(V, graph);
    }
}

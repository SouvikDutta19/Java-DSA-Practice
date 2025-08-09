import java.util.*;

public class day40_topological_sort_kahn {
    public static void topologicalSort(int V, List<List<Integer>> adj) {
        int[] inDegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int node : adj.get(i))
                inDegree[node]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++)
            if (inDegree[i] == 0)
                q.add(i);

        int count = 0;
        List<Integer> result = new ArrayList<>();

        while (!q.isEmpty()) {
            int u = q.poll();
            result.add(u);

            for (int node : adj.get(u)) {
                if (--inDegree[node] == 0)
                    q.add(node);
            }
            count++;
        }

        if (count != V)
            System.out.println("Graph has a cycle!");
        else
            System.out.println(result);
    }

    public static void main(String[] args) {
        int V = 6;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        topologicalSort(V, adj);
    }
}

import java.util.*;

public class day31_topologicalsortkahn {
    public static List<Integer> topologicalSort(int V, List<List<Integer>> adj) {
        int[] indegree = new int[V];
        for (List<Integer> list : adj)
            for (int node : list)
                indegree[node]++;

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++)
            if (indegree[i] == 0)
                q.add(i);

        List<Integer> result = new ArrayList<>();
        while (!q.isEmpty()) {
            int u = q.poll();
            result.add(u);
            for (int v : adj.get(u)) {
                indegree[v]--;
                if (indegree[v] == 0) q.add(v);
            }
        }

        if (result.size() != V) {
            System.out.println("Cycle detected! Topological sort not possible.");
            return new ArrayList<>();
        }

        return result;
    }

    public static void main(String[] args) {
        int V = 6;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        List<Integer> sorted = topologicalSort(V, adj);
        System.out.println("Topological Order: " + sorted);
    }
}

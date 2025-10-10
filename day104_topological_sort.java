import java.util.*;

// Topological Sorting using Kahn's Algorithm
public class day104_topological_sort {
    static void topologicalSort(int V, List<List<Integer>> adj) {
        int[] indegree = new int[V];
        for (int i = 0; i < V; i++)
            for (int node : adj.get(i))
                indegree[node]++;

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++)
            if (indegree[i] == 0)
                q.add(i);

        List<Integer> result = new ArrayList<>();
        while (!q.isEmpty()) {
            int curr = q.poll();
            result.add(curr);
            for (int node : adj.get(curr)) {
                indegree[node]--;
                if (indegree[node] == 0)
                    q.add(node);
            }
        }
        System.out.println("Topological Order: " + result);
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
        topologicalSort(V, adj);
    }
}

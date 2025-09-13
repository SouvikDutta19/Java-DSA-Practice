import java.util.*;

public class day74_toposort_kahn {
    public static void topoSort(List<List<Integer>> adj, int V) {
        int[] inDegree = new int[V];
        for (int u = 0; u < V; u++) for (int v : adj.get(u)) inDegree[v]++;

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) if (inDegree[i] == 0) q.add(i);

        List<Integer> result = new ArrayList<>();
        while (!q.isEmpty()) {
            int u = q.poll();
            result.add(u);
            for (int v : adj.get(u)) if (--inDegree[v] == 0) q.add(v);
        }

        if (result.size() != V) System.out.println("Graph has cycle!");
        else System.out.println("Topological Order: " + result);
    }

    public static void main(String[] args) {
        int V = 6;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        adj.get(5).add(2); adj.get(5).add(0);
        adj.get(4).add(0); adj.get(4).add(1);
        adj.get(2).add(3); adj.get(3).add(1);

        topoSort(adj, V);
    }
}

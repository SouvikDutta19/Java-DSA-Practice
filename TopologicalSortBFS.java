import java.util.*;

public class TopologicalSortBFS {
    static int V = 6;
    static List<List<Integer>> adj = new ArrayList<>();

    public static void addEdge(int u, int v) {
        adj.get(u).add(v);
    }

    public static void topologicalSort() {
        int[] inDegree = new int[V];
        for (int u = 0; u < V; u++) {
            for (int v : adj.get(u)) {
                inDegree[v]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0)
                q.add(i);
        }

        List<Integer> topoOrder = new ArrayList<>();
        while (!q.isEmpty()) {
            int u = q.poll();
            topoOrder.add(u);
            for (int v : adj.get(u)) {
                inDegree[v]--;
                if (inDegree[v] == 0)
                    q.add(v);
            }
        }

        System.out.println("Topological Order: " + topoOrder);
    }

    public static void main(String[] args) {
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        addEdge(5, 0);
        addEdge(5, 2);
        addEdge(4, 0);
        addEdge(4, 1);
        addEdge(2, 3);
        addEdge(3, 1);

        topologicalSort();
    }
}

import java.util.*;

public class day99_detectcycleundirected {
    static boolean isCyclicUtil(int v, boolean visited[], int parent, List<List<Integer>> adj) {
        visited[v] = true;
        for (int i : adj.get(v)) {
            if (!visited[i]) {
                if (isCyclicUtil(i, visited, v, adj)) return true;
            } else if (i != parent) return true;
        }
        return false;
    }

    static boolean isCyclic(List<List<Integer>> adj, int V) {
        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++)
            if (!visited[i] && isCyclicUtil(i, visited, -1, adj)) return true;
        return false;
    }

    public static void main(String[] args) {
        int V = 4;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        adj.get(0).add(1); adj.get(1).add(0);
        adj.get(1).add(2); adj.get(2).add(1);
        adj.get(2).add(0); adj.get(0).add(2);
        adj.get(2).add(3); adj.get(3).add(2);

        System.out.println(isCyclic(adj, V) ? "Cycle Found" : "No Cycle Found");
    }
}

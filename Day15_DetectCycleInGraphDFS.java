import java.util.*;

public class Day15_DetectCycleInGraphDFS {

    private static boolean isCyclicUtil(int node, boolean[] visited, boolean[] recStack, List<List<Integer>> adj) {
        visited[node] = true;
        recStack[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor] && isCyclicUtil(neighbor, visited, recStack, adj))
                return true;
            else if (recStack[neighbor])
                return true;
        }

        recStack[node] = false;
        return false;
    }

    public static boolean isCyclic(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i] && isCyclicUtil(i, visited, recStack, adj))
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int V = 4;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(0);
        adj.get(2).add(3);

        System.out.println("Contains cycle? " + isCyclic(V, adj));
    }
}

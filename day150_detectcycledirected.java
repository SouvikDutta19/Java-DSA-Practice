import java.util.*;

public class day150_detectcycledirected {

    private static boolean dfs(int node, List<List<Integer>> graph, boolean[] visited, boolean[] path) {
        visited[node] = true;
        path[node] = true;

        for (int neigh : graph.get(node)) {
            if (!visited[neigh]) {
                if (dfs(neigh, graph, visited, path)) return true;
            } else if (path[neigh]) {
                return true;
            }
        }

        path[node] = false;
        return false;
    }

    public static boolean hasCycle(int V, List<List<Integer>> graph) {
        boolean[] visited = new boolean[V];
        boolean[] path = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i] && dfs(i, graph, visited, path)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 4;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());

        graph.get(0).add(1);
        graph.get(1).add(2);
        graph.get(2).add(0); // cycle
        graph.get(2).add(3);

        System.out.println("Cycle exists? " + hasCycle(V, graph));
    }
}

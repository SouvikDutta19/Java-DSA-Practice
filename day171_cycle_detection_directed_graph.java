import java.util.*;

public class day171_cycle_detection_directed_graph {

    static boolean dfs(int node, List<List<Integer>> graph,
                       boolean[] visited, boolean[] recStack) {

        visited[node] = true;
        recStack[node] = true;

        for (int neigh : graph.get(node)) {
            if (!visited[neigh] && dfs(neigh, graph, visited, recStack))
                return true;
            else if (recStack[neigh])
                return true;
        }

        recStack[node] = false;
        return false;
    }

    public static boolean hasCycle(int V, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++)
            graph.add(new ArrayList<>());

        for (int[] e : edges)
            graph.get(e[0]).add(e[1]);

        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        for (int i = 0; i < V; i++)
            if (!visited[i] && dfs(i, graph, visited, recStack))
                return true;

        return false;
    }

    public static void main(String[] args) {
        int[][] edges = {
                {0, 1}, {1, 2}, {2, 0}
        };
        System.out.println("Cycle exists: " + hasCycle(3, edges));
    }
}
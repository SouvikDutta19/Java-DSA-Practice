import java.util.*;

public class day164_detect_cycle_directed_graph {

    static boolean dfs(int node, List<List<Integer>> graph,
                       boolean[] visited, boolean[] recStack) {

        visited[node] = true;
        recStack[node] = true;

        for (int nei : graph.get(node)) {
            if (!visited[nei] && dfs(nei, graph, visited, recStack))
                return true;
            else if (recStack[nei])
                return true;
        }

        recStack[node] = false;
        return false;
    }

    public static boolean hasCycle(int V, List<List<Integer>> graph) {
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        for (int i = 0; i < V; i++)
            if (!visited[i] && dfs(i, graph, visited, recStack))
                return true;

        return false;
    }

    public static void main(String[] args) {
        int V = 4;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());

        graph.get(0).add(1);
        graph.get(1).add(2);
        graph.get(2).add(3);
        graph.get(3).add(1);

        System.out.println("Cycle exists: " + hasCycle(V, graph));
    }
}
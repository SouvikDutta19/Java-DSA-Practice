import java.util.*;

public class day153_cycleindirected {

    public static boolean dfs(int node, int[] visited, int[] path, List<List<Integer>> graph) {
        visited[node] = 1;
        path[node] = 1;

        for (int neigh : graph.get(node)) {
            if (visited[neigh] == 0 && dfs(neigh, visited, path, graph))
                return true;
            else if (path[neigh] == 1)
                return true;
        }

        path[node] = 0;
        return false;
    }

    public static boolean isCyclic(int V, List<List<Integer>> graph) {
        int[] visited = new int[V];
        int[] path = new int[V];

        for (int i = 0; i < V; i++) {
            if (visited[i] == 0 && dfs(i, visited, path, graph))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 4;
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++)
            graph.add(new ArrayList<>());

        graph.get(0).add(1);
        graph.get(1).add(2);
        graph.get(2).add(0);
        graph.get(2).add(3);

        System.out.println("Cycle exists? " + isCyclic(V, graph));
    }
}
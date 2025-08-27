import java.util.*;

public class day58_dfs_on_graph {
    private Map<Integer, List<Integer>> adjList = new HashMap<>();

    public void addEdge(int u, int v) {
        adjList.putIfAbsent(u, new ArrayList<>());
        adjList.get(u).add(v);
        adjList.putIfAbsent(v, new ArrayList<>());
        adjList.get(v).add(u);
    }

    public void dfs(int start, Set<Integer> visited) {
        visited.add(start);
        System.out.print(start + " ");
        for (int neighbor : adjList.getOrDefault(start, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        day58_dfs_on_graph g = new day58_dfs_on_graph();
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 5);
        g.addEdge(4, 6);

        Set<Integer> visited = new HashSet<>();
        System.out.println("DFS Traversal:");
        g.dfs(1, visited);
    }
}

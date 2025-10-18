// Program to perform Depth First Search (DFS) traversal in a Graph

import java.util.*;

public class day111_graph_dfs {
    private Map<Integer, List<Integer>> adj = new HashMap<>();

    public void addEdge(int u, int v) {
        adj.putIfAbsent(u, new ArrayList<>());
        adj.get(u).add(v);
    }

    public void DFSUtil(int v, Set<Integer> visited) {
        visited.add(v);
        System.out.print(v + " ");

        for (int n : adj.getOrDefault(v, new ArrayList<>())) {
            if (!visited.contains(n))
                DFSUtil(n, visited);
        }
    }

    public void DFS(int v) {
        Set<Integer> visited = new HashSet<>();
        DFSUtil(v, visited);
    }

    public static void main(String[] args) {
        day111_graph_dfs g = new day111_graph_dfs();
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("DFS Traversal starting from vertex 2:");
        g.DFS(2);
    }
}

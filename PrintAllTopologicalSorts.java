import java.util.*;

public class PrintAllTopologicalSorts {
    private int vertices;
    private List<Integer>[] adj;

    public PrintAllTopologicalSorts(int v) {
        vertices = v;
        adj = new ArrayList[v];
        for (int i = 0; i < v; i++) adj[i] = new ArrayList<>();
    }

    public void addEdge(int u, int v) {
        adj[u].add(v);
    }

    public void allTopologicalSorts() {
        int[] inDegree = new int[vertices];
        for (int u = 0; u < vertices; u++) {
            for (int v : adj[u]) inDegree[v]++;
        }

        boolean[] visited = new boolean[vertices];
        List<Integer> res = new ArrayList<>();
        allTopoUtil(res, visited, inDegree);
    }

    private void allTopoUtil(List<Integer> res, boolean[] visited, int[] inDegree) {
        boolean flag = false;

        for (int i = 0; i < vertices; i++) {
            if (!visited[i] && inDegree[i] == 0) {
                visited[i] = true;
                res.add(i);
                for (int node : adj[i]) inDegree[node]--;

                allTopoUtil(res, visited, inDegree);

                visited[i] = false;
                res.remove(res.size() - 1);
                for (int node : adj[i]) inDegree[node]++;
                flag = true;
            }
        }

        if (!flag) System.out.println(res);
    }

    public static void main(String[] args) {
        PrintAllTopologicalSorts g = new PrintAllTopologicalSorts(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        System.out.println("All Topological Sorts:");
        g.allTopologicalSorts();
    }
}

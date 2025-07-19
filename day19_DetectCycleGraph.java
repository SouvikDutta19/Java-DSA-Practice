import java.util.*;

public class DetectCycleGraph {
    private int vertices;
    private List<List<Integer>> adj;

    public DetectCycleGraph(int v) {
        vertices = v;
        adj = new ArrayList<>();
        for (int i = 0; i < v; i++) adj.add(new ArrayList<>());
    }

    public void addEdge(int u, int v) {
        adj.get(u).add(v);
    }

    public boolean isCyclic() {
        boolean[] visited = new boolean[vertices];
        boolean[] recStack = new boolean[vertices];
        for (int i = 0; i < vertices; i++)
            if (dfs(i, visited, recStack))
                return true;
        return false;
    }

    private boolean dfs(int v, boolean[] visited, boolean[] recStack) {
        if (recStack[v]) return true;
        if (visited[v]) return false;

        visited[v] = true;
        recStack[v] = true;

        for (int neighbor : adj.get(v))
            if (dfs(neighbor, visited, recStack)) return true;

        recStack[v] = false;
        return false;
    }

    public static void main(String[] args) {
        DetectCycleGraph g = new DetectCycleGraph(4);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        System.out.println(g.isCyclic());
    }
}

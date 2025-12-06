import java.util.*;

public class day156_kosaraju_scc {

    private int V;
    private List<Integer>[] adj;

    day156_kosaraju_scc(int v) {
        V = v;
        adj = new ArrayList[v];
        for (int i = 0; i < v; i++)
            adj[i] = new ArrayList<>();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void fillOrder(int v, boolean visited[], Stack<Integer> stack) {
        visited[v] = true;

        for (int n : adj[v]) {
            if (!visited[n])
                fillOrder(n, visited, stack);
        }
        stack.push(v);
    }

    day156_kosaraju_scc getTranspose() {
        day156_kosaraju_scc g = new day156_kosaraju_scc(V);

        for (int v = 0; v < V; v++) {
            for (int n : adj[v])
                g.addEdge(n, v);
        }
        return g;
    }

    void dfs(int v, boolean visited[]) {
        visited[v] = true;
        System.out.print(v + " ");

        for (int n : adj[v]) {
            if (!visited[n])
                dfs(n, visited);
        }
    }

    void printSCCs() {
        Stack<Integer> stack = new Stack<>();
        boolean visited[] = new boolean[V];

        for (int i = 0; i < V; i++)
            if (!visited[i])
                fillOrder(i, visited, stack);

        day156_kosaraju_scc transposeGraph = getTranspose();
        Arrays.fill(visited, false);

        while (!stack.isEmpty()) {
            int v = stack.pop();

            if (!visited[v]) {
                transposeGraph.dfs(v, visited);
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        day156_kosaraju_scc g = new day156_kosaraju_scc(5);

        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);

        System.out.println("Strongly Connected Components:");
        g.printSCCs();
    }
}
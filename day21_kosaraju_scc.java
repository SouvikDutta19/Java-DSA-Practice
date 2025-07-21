import java.util.*;

public class day21_kosaraju_scc {
    static class Graph {
        int V;
        List<Integer>[] adj;

        Graph(int V) {
            this.V = V;
            adj = new ArrayList[V];
            for (int i = 0; i < V; i++) adj[i] = new ArrayList<>();
        }

        void addEdge(int u, int v) {
            adj[u].add(v);
        }

        void dfs(int v, boolean[] visited, Stack<Integer> stack) {
            visited[v] = true;
            for (int u : adj[v])
                if (!visited[u])
                    dfs(u, visited, stack);
            stack.push(v);
        }

        void dfsUtil(int v, boolean[] visited, List<Integer>[] revAdj, List<Integer> comp) {
            visited[v] = true;
            comp.add(v);
            for (int u : revAdj[v])
                if (!visited[u])
                    dfsUtil(u, visited, revAdj, comp);
        }

        void kosaraju() {
            Stack<Integer> stack = new Stack<>();
            boolean[] visited = new boolean[V];

            for (int i = 0; i < V; i++)
                if (!visited[i])
                    dfs(i, visited, stack);

            List<Integer>[] revAdj = new ArrayList[V];
            for (int i = 0; i < V; i++) revAdj[i] = new ArrayList<>();
            for (int u = 0; u < V; u++)
                for (int v : adj[u])
                    revAdj[v].add(u);

            Arrays.fill(visited, false);
            System.out.println("Strongly Connected Components:");
            while (!stack.isEmpty()) {
                int v = stack.pop();
                if (!visited[v]) {
                    List<Integer> comp = new ArrayList<>();
                    dfsUtil(v, visited, revAdj, comp);
                    System.out.println(comp);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);

        g.kosaraju();
    }
}

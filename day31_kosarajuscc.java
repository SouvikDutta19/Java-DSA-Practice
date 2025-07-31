import java.util.*;

public class day31_kosarajuscc {
    static int V = 5;
    static List<List<Integer>> graph = new ArrayList<>();
    static List<List<Integer>> transpose = new ArrayList<>();
    static boolean[] visited;

    static void addEdge(int u, int v) {
        graph.get(u).add(v);
    }

    static void dfs(int u, Stack<Integer> stack) {
        visited[u] = true;
        for (int v : graph.get(u)) {
            if (!visited[v])
                dfs(v, stack);
        }
        stack.push(u);
    }

    static void reverseDFS(int u) {
        visited[u] = true;
        System.out.print(u + " ");
        for (int v : transpose.get(u)) {
            if (!visited[v])
                reverseDFS(v);
        }
    }

    static void kosaraju() {
        Stack<Integer> stack = new Stack<>();
        visited = new boolean[V];

        for (int i = 0; i < V; i++)
            if (!visited[i])
                dfs(i, stack);

        for (int i = 0; i < V; i++)
            for (int j : graph.get(i))
                transpose.get(j).add(i);

        visited = new boolean[V];
        System.out.println("Strongly Connected Components:");
        while (!stack.isEmpty()) {
            int v = stack.pop();
            if (!visited[v]) {
                reverseDFS(v);
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
            transpose.add(new ArrayList<>());
        }
        addEdge(1, 0);
        addEdge(0, 2);
        addEdge(2, 1);
        addEdge(0, 3);
        addEdge(3, 4);

        kosaraju();
    }
}

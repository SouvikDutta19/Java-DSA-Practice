import java.util.*;

public class day144_dfs_toposort {

    private static void dfs(int v, boolean[] visited, Stack<Integer> stack, List<List<Integer>> graph) {
        visited[v] = true;
        for (int neigh : graph.get(v))
            if (!visited[neigh])
                dfs(neigh, visited, stack, graph);

        stack.push(v);
    }

    public static void topoSort(int n, List<List<Integer>> graph) {
        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++)
            if (!visited[i])
                dfs(i, visited, stack, graph);

        System.out.println("Topological Ordering:");
        while (!stack.isEmpty())
            System.out.print(stack.pop() + " ");
    }

    public static void main(String[] args) {
        int n = 6;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        graph.get(5).add(2);
        graph.get(5).add(0);
        graph.get(4).add(0);
        graph.get(4).add(1);
        graph.get(2).add(3);
        graph.get(3).add(1);

        topoSort(n, graph);
    }
}

import java.util.*;

public class day53_biconnected_components {
    static int time = 0;
    static Stack<int[]> stack = new Stack<>();

    public static void dfs(List<List<Integer>> adj, int u, int parent, int[] disc, int[] low, boolean[] visited) {
        visited[u] = true;
        disc[u] = low[u] = ++time;
        int children = 0;

        for (int v : adj.get(u)) {
            if (disc[v] == -1) {
                children++;
                stack.push(new int[]{u, v});
                dfs(adj, v, u, disc, low, visited);
                low[u] = Math.min(low[u], low[v]);

                if (low[v] >= disc[u]) {
                    System.out.print("Biconnected component: ");
                    while (!stack.isEmpty() && (stack.peek()[0] != u || stack.peek()[1] != v)) {
                        int[] edge = stack.pop();
                        System.out.print("(" + edge[0] + "," + edge[1] + ") ");
                    }
                    int[] edge = stack.pop();
                    System.out.print("(" + edge[0] + "," + edge[1] + ")");
                    System.out.println();
                }
            } else if (v != parent && disc[v] < disc[u]) {
                low[u] = Math.min(low[u], disc[v]);
                stack.push(new int[]{u, v});
            }
        }
    }

    public static void findBCC(List<List<Integer>> adj, int n) {
        int[] disc = new int[n];
        int[] low = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);

        for (int i = 0; i < n; i++) {
            if (disc[i] == -1)
                dfs(adj, i, -1, disc, low, visited);
        }
    }

    public static void main(String[] args) {
        int n = 5;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        adj.get(0).add(1); adj.get(1).add(0);
        adj.get(1).add(2); adj.get(2).add(1);
        adj.get(2).add(0); adj.get(0).add(2);
        adj.get(1).add(3); adj.get(3).add(1);
        adj.get(3).add(4); adj.get(4).add(3);

        findBCC(adj, n);
    }
}

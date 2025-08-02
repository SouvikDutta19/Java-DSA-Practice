import java.util.*;

public class day33_tarjansalgorithmbridges {
    static int time = 0;
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] disc, low;
    static boolean[] visited;

    public static void dfs(int u, int parent, List<int[]> bridges) {
        visited[u] = true;
        disc[u] = low[u] = ++time;

        for (int v : graph.get(u)) {
            if (v == parent) continue;

            if (!visited[v]) {
                dfs(v, u, bridges);
                low[u] = Math.min(low[u], low[v]);

                if (low[v] > disc[u]) {
                    bridges.add(new int[]{u, v});
                }
            } else {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    public static List<int[]> findBridges(int n) {
        disc = new int[n];
        low = new int[n];
        visited = new boolean[n];
        List<int[]> bridges = new ArrayList<>();

        for (int i = 0; i < n; i++)
            if (!visited[i])
                dfs(i, -1, bridges);

        return bridges;
    }

    public static void main(String[] args) {
        int n = 5;
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        graph.get(0).add(1);
        graph.get(1).add(0);
        graph.get(1).add(2);
        graph.get(2).add(1);
        graph.get(2).add(0);
        graph.get(0).add(2);
        graph.get(1).add(3);
        graph.get(3).add(1);
        graph.get(3).add(4);
        graph.get(4).add(3);

        List<int[]> bridges = findBridges(n);
        System.out.println("Bridges in the graph:");
        for (int[] bridge : bridges)
            System.out.println(bridge[0] + " - " + bridge[1]);
    }
}

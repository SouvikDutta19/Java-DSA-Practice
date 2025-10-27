// day120_criticalconnections.java
import java.util.*;

public class day120_criticalconnections {
    private int time = 0;
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (List<Integer> edge : connections) {
            graph[edge.get(0)].add(edge.get(1));
            graph[edge.get(1)].add(edge.get(0));
        }

        int[] disc = new int[n], low = new int[n];
        Arrays.fill(disc, -1);
        List<List<Integer>> bridges = new ArrayList<>();
        for (int i = 0; i < n; i++)
            if (disc[i] == -1)
                dfs(i, -1, graph, disc, low, bridges);
        return bridges;
    }

    private void dfs(int u, int parent, List<Integer>[] graph, int[] disc, int[] low, List<List<Integer>> bridges) {
        disc[u] = low[u] = ++time;
        for (int v : graph[u]) {
            if (v == parent) continue;
            if (disc[v] == -1) {
                dfs(v, u, graph, disc, low, bridges);
                low[u] = Math.min(low[u], low[v]);
                if (low[v] > disc[u])
                    bridges.add(Arrays.asList(u, v));
            } else {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    public static void main(String[] args) {
        day120_criticalconnections obj = new day120_criticalconnections();
        List<List<Integer>> connections = Arrays.asList(
            Arrays.asList(0, 1), Arrays.asList(1, 2), Arrays.asList(2, 0), Arrays.asList(1, 3)
        );
        System.out.println(obj.criticalConnections(4, connections));
    }
}

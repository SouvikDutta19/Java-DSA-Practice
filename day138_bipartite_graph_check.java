// day138_bipartite_graph_check.java
import java.util.*;

public class day138_bipartite_graph_check {
    public static boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        Arrays.fill(colors, -1);

        for (int i = 0; i < n; i++) {
            if (colors[i] == -1) {
                if (!bfs(graph, colors, i)) return false;
            }
        }
        return true;
    }

    private static boolean bfs(int[][] graph, int[] colors, int start) {
        Queue<Integer> queue = new LinkedList<>();
        colors[start] = 0;
        queue.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int nei : graph[node]) {
                if (colors[nei] == -1) {
                    colors[nei] = colors[node] ^ 1;
                    queue.add(nei);
                } else if (colors[nei] == colors[node]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] graph = {{1,3},{0,2},{1,3},{0,2}};
        System.out.println("Is Bipartite: " + isBipartite(graph));
    }
}

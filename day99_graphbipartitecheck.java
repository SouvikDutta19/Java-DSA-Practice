import java.util.*;

public class day99_graphbipartitecheck {
    static boolean isBipartite(int[][] graph, int V) {
        int[] color = new int[V];
        Arrays.fill(color, -1);

        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (!bfsCheck(graph, i, color)) return false;
            }
        }
        return true;
    }

    static boolean bfsCheck(int[][] graph, int src, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        color[src] = 1;

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int i = 0; i < graph[node].length; i++) {
                int adj = graph[node][i];
                if (color[adj] == -1) {
                    color[adj] = 1 - color[node];
                    q.add(adj);
                } else if (color[adj] == color[node]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] graph = {{1,3},{0,2},{1,3},{0,2}};
        System.out.println(isBipartite(graph, 4) ? "Graph is Bipartite" : "Graph is not Bipartite");
    }
}

import java.util.*;

public class day74_bipartite_check {
    public static boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);

        for (int start = 0; start < n; start++) {
            if (color[start] == -1) {
                Queue<Integer> q = new LinkedList<>();
                q.offer(start);
                color[start] = 0;

                while (!q.isEmpty()) {
                    int u = q.poll();
                    for (int v : graph[u]) {
                        if (color[v] == -1) {
                            color[v] = 1 - color[u];
                            q.offer(v);
                        } else if (color[v] == color[u]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] graph = {{1,3},{0,2},{1,3},{0,2}};
        System.out.println("Graph Bipartite? " + isBipartite(graph));
    }
}

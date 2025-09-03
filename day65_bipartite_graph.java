import java.util.*;

public class day65_bipartite_graph {
    public static boolean isBipartite(int[][] graph, int V) {
        int[] color = new int[V];
        Arrays.fill(color, -1);

        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                color[i] = 1;

                while (!queue.isEmpty()) {
                    int u = queue.poll();
                    for (int v = 0; v < V; v++) {
                        if (graph[u][v] == 1 && color[v] == -1) {
                            color[v] = 1 - color[u];
                            queue.add(v);
                        } else if (graph[u][v] == 1 && color[v] == color[u]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 1, 0, 1},
                {1, 0, 1, 0},
                {0, 1, 0, 1},
                {1, 0, 1, 0}
        };
        System.out.println("Is graph bipartite? " + isBipartite(graph, 4));
    }
}

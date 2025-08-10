import java.util.*;

public class day41_bipartite_graph_check {
    public static boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);

        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) {
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                color[i] = 0;

                while (!q.isEmpty()) {
                    int node = q.poll();
                    for (int neighbor : graph[node]) {
                        if (color[neighbor] == -1) {
                            color[neighbor] = 1 - color[node];
                            q.add(neighbor);
                        } else if (color[neighbor] == color[node]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] graph1 = {{1,3},{0,2},{1,3},{0,2}};
        int[][] graph2 = {{1,2,3},{0,2},{0,1,3},{0,2}};

        System.out.println(isBipartite(graph1));
        System.out.println(isBipartite(graph2));
    }
}

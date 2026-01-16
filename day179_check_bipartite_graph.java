import java.util.*;

public class day179_check_bipartite_graph {

    public static boolean isBipartite(int V, List<List<Integer>> graph) {
        int[] color = new int[V];
        Arrays.fill(color, -1);

        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                color[i] = 0;

                while (!q.isEmpty()) {
                    int u = q.poll();
                    for (int v : graph.get(u)) {
                        if (color[v] == -1) {
                            color[v] = 1 - color[u];
                            q.add(v);
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
        int V = 4;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());

        graph.get(0).add(1); graph.get(1).add(0);
        graph.get(2).add(3); graph.get(3).add(2);

        System.out.println(isBipartite(V, graph));
    }
}
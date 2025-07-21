import java.util.*;

public class day21_bipartite_graph_check {
    public static boolean isBipartite(List<Integer>[] graph, int V) {
        int[] color = new int[V];
        Arrays.fill(color, -1);

        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                color[i] = 0;

                while (!queue.isEmpty()) {
                    int u = queue.poll();
                    for (int v : graph[u]) {
                        if (color[v] == -1) {
                            color[v] = 1 - color[u];
                            queue.add(v);
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
        int V = 6;
        List<Integer>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) graph[i] = new ArrayList<>();
        graph[0].add(1); graph[1].add(0);
        graph[1].add(2); graph[2].add(1);
        graph[2].add(3); graph[3].add(2);
        graph[3].add(4); graph[4].add(3);
        graph[4].add(5); graph[5].add(4);
        graph[5].add(0); graph[0].add(5); // Forms a cycle of odd length

        System.out.println("Is Bipartite: " + isBipartite(graph, V));
    }
}

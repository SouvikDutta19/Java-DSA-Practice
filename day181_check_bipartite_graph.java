import java.util.*;

public class day181_check_bipartite_graph {

    static boolean bfs(int src, int[] color, List<List<Integer>> g) {
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        color[src] = 0;

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : g.get(u)) {
                if (color[v] == -1) {
                    color[v] = 1 - color[u];
                    q.add(v);
                } else if (color[v] == color[u]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int V = 4;
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < V; i++) g.add(new ArrayList<>());

        g.get(0).add(1);
        g.get(1).add(2);
        g.get(2).add(3);

        int[] color = new int[V];
        Arrays.fill(color, -1);

        System.out.println(bfs(0, color, g));
    }
}
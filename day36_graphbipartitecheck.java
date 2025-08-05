import java.util.*;

public class day36_graphbipartitecheck {
    public static void main(String[] args) {
        int V = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        adj.get(0).add(1); adj.get(1).add(0);
        adj.get(1).add(2); adj.get(2).add(1);
        adj.get(2).add(3); adj.get(3).add(2);
        adj.get(3).add(0); adj.get(0).add(3); // cycle of even length

        boolean isBipartite = checkBipartite(adj, V);
        System.out.println("Graph is bipartite: " + isBipartite);
    }

    static boolean checkBipartite(ArrayList<ArrayList<Integer>> adj, int V) {
        int[] color = new int[V];
        Arrays.fill(color, -1);

        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (!bfsColoring(adj, i, color)) return false;
            }
        }
        return true;
    }

    static boolean bfsColoring(ArrayList<ArrayList<Integer>> adj, int start, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int neighbor : adj.get(node)) {
                if (color[neighbor] == -1) {
                    color[neighbor] = 1 - color[node];
                    q.add(neighbor);
                } else if (color[neighbor] == color[node])
                    return false;
            }
        }
        return true;
    }
}

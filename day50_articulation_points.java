import java.util.*;

public class day50_articulation_points {
    private int time = 0;

    public void APUtil(int u, boolean[] visited, int[] disc, int[] low, int[] parent, boolean[] ap, List<Integer>[] adj) {
        int children = 0;
        visited[u] = true;
        disc[u] = low[u] = ++time;

        for (int v : adj[u]) {
            if (!visited[v]) {
                children++;
                parent[v] = u;
                APUtil(v, visited, disc, low, parent, ap, adj);
                low[u] = Math.min(low[u], low[v]);

                if (parent[u] == -1 && children > 1)
                    ap[u] = true;

                if (parent[u] != -1 && low[v] >= disc[u])
                    ap[u] = true;
            } else if (v != parent[u]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    public void findAP(List<Integer>[] adj, int V) {
        boolean[] visited = new boolean[V];
        int[] disc = new int[V];
        int[] low = new int[V];
        int[] parent = new int[V];
        boolean[] ap = new boolean[V];

        Arrays.fill(parent, -1);

        for (int i = 0; i < V; i++) {
            if (!visited[i])
                APUtil(i, visited, disc, low, parent, ap, adj);
        }

        System.out.print("Articulation points: ");
        for (int i = 0; i < V; i++) {
            if (ap[i])
                System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        int V = 5;
        List<Integer>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }

        adj[0].add(1); adj[1].add(0);
        adj[0].add(2); adj[2].add(0);
        adj[1].add(2); adj[2].add(1);
        adj[1].add(3); adj[3].add(1);
        adj[3].add(4); adj[4].add(3);

        day50_articulation_points obj = new day50_articulation_points();
        obj.findAP(adj, V);
    }
}

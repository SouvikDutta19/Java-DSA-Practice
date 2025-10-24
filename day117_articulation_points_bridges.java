import java.util.*;
// Find articulation points and bridges in an undirected graph
public class day117_articulation_points_bridges {
    int N, time = 0;
    List<Integer>[] g;
    int[] disc, low, parent;
    boolean[] ap;
    List<int[]> bridges;

    @SuppressWarnings("unchecked")
    public day117_articulation_points_bridges(int n) {
        N = n;
        g = new List[N];
        for (int i = 0; i < N; i++) g[i] = new ArrayList<>();
        disc = new int[N]; Arrays.fill(disc, -1);
        low = new int[N];
        parent = new int[N]; Arrays.fill(parent, -1);
        ap = new boolean[N];
        bridges = new ArrayList<>();
    }

    void addEdge(int u, int v) { g[u].add(v); g[v].add(u); }

    void dfsAP(int u) {
        disc[u] = low[u] = ++time;
        int children = 0;
        for (int v : g[u]) {
            if (disc[v] == -1) {
                children++;
                parent[v] = u;
                dfsAP(v);
                low[u] = Math.min(low[u], low[v]);
                if (parent[u] == -1 && children > 1) ap[u] = true;
                if (parent[u] != -1 && low[v] >= disc[u]) ap[u] = true;
                if (low[v] > disc[u]) bridges.add(new int[]{u,v});
            } else if (v != parent[u]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    void findAPandBridges() {
        for (int i = 0; i < N; i++)
            if (disc[i] == -1) dfsAP(i);
    }

    public static void main(String[] args) {
        day117_articulation_points_bridges g = new day117_articulation_points_bridges(5);
        g.addEdge(1,0); g.addEdge(0,2); g.addEdge(2,1); g.addEdge(0,3); g.addEdge(3,4);
        g.findAPandBridges();
        System.out.println("Articulation Points:");
        for (int i = 0; i < g.N; i++) if (g.ap[i]) System.out.println(i);
        System.out.println("Bridges:");
        for (int[] b : g.bridges) System.out.println(b[0] + " - " + b[1]);
    }
}

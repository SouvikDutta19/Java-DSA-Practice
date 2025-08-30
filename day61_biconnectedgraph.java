import java.util.*;

public class day61_biconnectedgraph {
    private int V;
    private LinkedList<Integer>[] adj;
    private int time;
    private static final int NIL = -1;

    public day61_biconnectedgraph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
        time = 0;
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    void BCCUtil(int u, int parent[], int disc[], int low[], Stack<int[]> st) {
        disc[u] = low[u] = ++time;
        int children = 0;

        for (int v : adj[u]) {
            if (disc[v] == -1) {
                children++;
                parent[v] = u;
                st.push(new int[]{u, v});
                BCCUtil(v, parent, disc, low, st);
                low[u] = Math.min(low[u], low[v]);

                if ((disc[u] == 1 && children > 1) || (disc[u] > 1 && low[v] >= disc[u])) {
                    while (st.peek()[0] != u || st.peek()[1] != v) {
                        System.out.print(Arrays.toString(st.pop()) + " ");
                    }
                    System.out.println(Arrays.toString(st.pop()));
                }
            } else if (v != parent[u] && disc[v] < disc[u]) {
                low[u] = Math.min(low[u], disc[v]);
                st.push(new int[]{u, v});
            }
        }
    }

    void BCC() {
        int disc[] = new int[V];
        int low[] = new int[V];
        int parent[] = new int[V];
        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);
        Arrays.fill(parent, -1);

        Stack<int[]> st = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (disc[i] == -1) {
                BCCUtil(i, parent, disc, low, st);

                while (!st.isEmpty()) {
                    System.out.print(Arrays.toString(st.pop()) + " ");
                }
            }
        }
    }

    public static void main(String[] args) {
        day61_biconnectedgraph g = new day61_biconnectedgraph(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);

        System.out.println("Biconnected Components:");
        g.BCC();
    }
}

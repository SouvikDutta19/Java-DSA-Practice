import java.util.*;

public class day47_tarjans_scc {
    private int V, time;
    private LinkedList<Integer>[] adj;
    private int[] disc, low;
    private boolean[] stackMember;
    private Stack<Integer> stack;

    public day47_tarjans_scc(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) adj[i] = new LinkedList<>();
        disc = new int[v];
        low = new int[v];
        stackMember = new boolean[v];
        stack = new Stack<>();
        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void SCCUtil(int u) {
        disc[u] = low[u] = ++time;
        stack.push(u);
        stackMember[u] = true;

        for (int v : adj[u]) {
            if (disc[v] == -1) {
                SCCUtil(v);
                low[u] = Math.min(low[u], low[v]);
            } else if (stackMember[v]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }

        if (low[u] == disc[u]) {
            while (true) {
                int v = stack.pop();
                stackMember[v] = false;
                System.out.print(v + " ");
                if (v == u) break;
            }
            System.out.println();
        }
    }

    void SCC() {
        for (int i = 0; i < V; i++) if (disc[i] == -1) SCCUtil(i);
    }

    public static void main(String[] args) {
        day47_tarjans_scc g = new day47_tarjans_scc(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);
        System.out.println("Strongly Connected Components:");
        g.SCC();
    }
}

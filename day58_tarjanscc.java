import java.util.*;

public class day58_tarjanscc {
    private int V, time;
    private LinkedList<Integer>[] adj;
    private int[] disc, low;
    private boolean[] stackMember;
    private Stack<Integer> stack;

    public day58_tarjanscc(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) adj[i] = new LinkedList<>();
        disc = new int[v];
        low = new int[v];
        stackMember = new boolean[v];
        stack = new Stack<>();
        time = 0;
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void SCCUtil(int u) {
        disc[u] = low[u] = ++time;
        stack.push(u);
        stackMember[u] = true;
        for (int v : adj[u]) {
            if (disc[v] == 0) {
                SCCUtil(v);
                low[u] = Math.min(low[u], low[v]);
            } else if (stackMember[v]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
        if (low[u] == disc[u]) {
            int w;
            do {
                w = stack.pop();
                stackMember[w] = false;
                System.out.print(w + " ");
            } while (w != u);
            System.out.println();
        }
    }

    void SCC() {
        for (int i = 0; i < V; i++)
            if (disc[i] == 0) SCCUtil(i);
    }

    public static void main(String[] args) {
        day58_tarjanscc g = new day58_tarjanscc(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);
        System.out.println("Strongly Connected Components:");
        g.SCC();
    }
}

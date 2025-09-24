import java.util.*;

public class day89_tarjan_scc {
    private int time = 0;
    private int[] disc, low;
    private boolean[] stackMember;
    private Stack<Integer> stack;
    private List<List<Integer>> adj;

    public day89_tarjan_scc(int V) {
        disc = new int[V];
        low = new int[V];
        stackMember = new boolean[V];
        stack = new Stack<>();
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
    }

    public void addEdge(int u, int v) { adj.get(u).add(v); }

    private void SCCUtil(int u) {
        disc[u] = low[u] = ++time;
        stack.push(u);
        stackMember[u] = true;

        for (int v : adj.get(u)) {
            if (disc[v] == -1) {
                SCCUtil(v);
                low[u] = Math.min(low[u], low[v]);
            } else if (stackMember[v]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }

        int w = -1;
        if (low[u] == disc[u]) {
            while (w != u) {
                w = stack.pop();
                stackMember[w] = false;
                System.out.print(w + " ");
            }
            System.out.println();
        }
    }

    public void SCC() {
        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);
        for (int i = 0; i < adj.size(); i++) {
            if (disc[i] == -1) SCCUtil(i);
        }
    }

    public static void main(String[] args) {
        day89_tarjan_scc g = new day89_tarjan_scc(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);
        g.SCC();
    }
}

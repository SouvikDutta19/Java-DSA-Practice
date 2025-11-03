import java.util.*;

public class day127_tarjan_scc {
    static int time = 0;
    static Stack<Integer> stack = new Stack<>();

    static void sccUtil(int u, int[] disc, int[] low, boolean[] stackMember, List<List<Integer>> adj) {
        disc[u] = low[u] = ++time;
        stack.push(u);
        stackMember[u] = true;

        for (int v : adj.get(u)) {
            if (disc[v] == -1) {
                sccUtil(v, disc, low, stackMember, adj);
                low[u] = Math.min(low[u], low[v]);
            } else if (stackMember[v])
                low[u] = Math.min(low[u], disc[v]);
        }

        if (low[u] == disc[u]) {
            System.out.print("SCC: ");
            int w;
            do {
                w = stack.pop();
                System.out.print(w + " ");
                stackMember[w] = false;
            } while (w != u);
            System.out.println();
        }
    }

    static void tarjanSCC(List<List<Integer>> adj, int V) {
        int[] disc = new int[V];
        int[] low = new int[V];
        boolean[] stackMember = new boolean[V];
        Arrays.fill(disc, -1);

        for (int i = 0; i < V; i++)
            if (disc[i] == -1)
                sccUtil(i, disc, low, stackMember, adj);
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        adj.get(1).add(0);
        adj.get(0).add(2);
        adj.get(2).add(1);
        adj.get(0).add(3);
        adj.get(3).add(4);

        tarjanSCC(adj, V);
    }
}

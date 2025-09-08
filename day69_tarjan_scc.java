import java.util.*;

public class day69_tarjan_scc {
    static int time = 0;
    static void dfs(int u, List<List<Integer>> adj, int[] disc, int[] low, boolean[] stackMember, Stack<Integer> st) {
        disc[u] = low[u] = ++time;
        st.push(u);
        stackMember[u] = true;
        for (int v : adj.get(u)) {
            if (disc[v] == -1) {
                dfs(v, adj, disc, low, stackMember, st);
                low[u] = Math.min(low[u], low[v]);
            } else if (stackMember[v]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
        if (low[u] == disc[u]) {
            while (st.peek() != u) {
                System.out.print(st.pop() + " ");
            }
            System.out.println(st.pop());
        }
    }

    public static void main(String[] args) {
        int n = 5;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        adj.get(0).add(2); adj.get(2).add(1); adj.get(1).add(0);
        adj.get(0).add(3); adj.get(3).add(4);

        int[] disc = new int[n], low = new int[n];
        boolean[] stackMember = new boolean[n];
        Arrays.fill(disc, -1);
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) if (disc[i] == -1) dfs(i, adj, disc, low, stackMember, st);
    }
}

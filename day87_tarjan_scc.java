import java.util.*;

public class day87_tarjan_scc {
    static int time = 0;
    static List<List<Integer>> sccs = new ArrayList<>();
    static void dfs(int u, List<Integer>[] graph, int[] disc, int[] low, boolean[] stackMember, Stack<Integer> st) {
        disc[u] = low[u] = ++time;
        st.push(u);
        stackMember[u] = true;
        for (int v : graph[u]) {
            if (disc[v] == -1) {
                dfs(v, graph, disc, low, stackMember, st);
                low[u] = Math.min(low[u], low[v]);
            } else if (stackMember[v]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
        if (low[u] == disc[u]) {
            List<Integer> comp = new ArrayList<>();
            int v;
            do {
                v = st.pop();
                stackMember[v] = false;
                comp.add(v);
            } while (u != v);
            sccs.add(comp);
        }
    }

    public static void main(String[] args) {
        int n = 5;
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        graph[1].add(0);
        graph[0].add(2);
        graph[2].add(1);
        graph[0].add(3);
        graph[3].add(4);

        int[] disc = new int[n], low = new int[n];
        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);
        boolean[] stackMember = new boolean[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) if (disc[i] == -1) dfs(i, graph, disc, low, stackMember, st);
        System.out.println(sccs);
    }
}

import java.io.*;
import java.util.*;

public class day66_tarjan_scc {
    static int time = 0;
    static void dfs(int u, int[] disc, int[] low, boolean[] stackMember, Stack<Integer> stack, List<List<Integer>> adj) {
        disc[u] = low[u] = ++time;
        stack.push(u); stackMember[u] = true;

        for (int v : adj.get(u)) {
            if (disc[v] == -1) {
                dfs(v, disc, low, stackMember, stack, adj);
                low[u] = Math.min(low[u], low[v]);
            } else if (stackMember[v]) low[u] = Math.min(low[u], disc[v]);
        }

        if (low[u] == disc[u]) {
            List<Integer> comp = new ArrayList<>();
            while (stack.peek() != u) comp.add(stack.pop());
            comp.add(stack.pop());
            System.out.println(comp);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken());
            adj.get(u).add(v);
        }

        int[] disc = new int[n], low = new int[n];
        Arrays.fill(disc, -1);
        boolean[] stackMember = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) if (disc[i] == -1) dfs(i, disc, low, stackMember, stack, adj);
    }
}

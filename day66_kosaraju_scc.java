import java.io.*;
import java.util.*;

public class day66_kosaraju_scc {
    static void dfs1(int v, boolean[] visited, Stack<Integer> stack, List<List<Integer>> adj) {
        visited[v] = true;
        for (int u : adj.get(v)) if (!visited[u]) dfs1(u, visited, stack, adj);
        stack.push(v);
    }

    static void dfs2(int v, boolean[] visited, List<Integer> comp, List<List<Integer>> radj) {
        visited[v] = true; comp.add(v);
        for (int u : radj.get(v)) if (!visited[u]) dfs2(u, visited, comp, radj);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        List<List<Integer>> adj = new ArrayList<>(), radj = new ArrayList<>();
        for (int i = 0; i < n; i++) { adj.add(new ArrayList<>()); radj.add(new ArrayList<>()); }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken());
            adj.get(u).add(v); radj.get(v).add(u);
        }

        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) if (!visited[i]) dfs1(i, visited, stack, adj);

        Arrays.fill(visited, false);
        while (!stack.isEmpty()) {
            int v = stack.pop();
            if (!visited[v]) {
                List<Integer> comp = new ArrayList<>();
                dfs2(v, visited, comp, radj);
                System.out.println(comp);
            }
        }
    }
}

import java.io.*;
import java.util.*;

public class day66_lca_binary_lifting {
    static int LOG = 20;
    static int[][] up;
    static int[] depth;
    static List<List<Integer>> adj;

    static void dfs(int v, int p) {
        up[v][0] = p;
        for (int i = 1; i < LOG; i++) up[v][i] = up[up[v][i-1]][i-1];
        for (int u : adj.get(v)) {
            if (u != p) {
                depth[u] = depth[v] + 1;
                dfs(u, v);
            }
        }
    }

    static int lca(int a, int b) {
        if (depth[a] < depth[b]) { int tmp = a; a = b; b = tmp; }
        int k = depth[a] - depth[b];
        for (int i = LOG-1; i >= 0; i--) if ((k & (1 << i)) > 0) a = up[a][i];
        if (a == b) return a;
        for (int i = LOG-1; i >= 0; i--) if (up[a][i] != up[b][i]) { a = up[a][i]; b = up[b][i]; }
        return up[a][0];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken());
            adj.get(u).add(v); adj.get(v).add(u);
        }
        up = new int[n][LOG];
        depth = new int[n];
        dfs(0, 0);

        System.out.println(lca(2, 4));
    }
}

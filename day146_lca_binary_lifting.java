import java.util.*;

public class day146_lca_binary_lifting {

    static int N = 100005, LOG = 17;
    static ArrayList<Integer>[] adj = new ArrayList[N];
    static int[][] parent = new int[N][LOG];
    static int[] level = new int[N];

    static void dfs(int node, int par, int depth) {
        parent[node][0] = par;
        level[node] = depth;

        for (int nbr : adj[node]) {
            if (nbr != par) dfs(nbr, node, depth + 1);
        }
    }

    static void preprocess(int n) {
        for (int j = 1; j < LOG; j++) {
            for (int i = 1; i <= n; i++) {
                parent[i][j] = parent[parent[i][j-1]][j-1];
            }
        }
    }

    static int lca(int a, int b) {
        if (level[a] < level[b]) {
            int temp = a; a = b; b = temp;
        }

        int diff = level[a] - level[b];
        for (int i = LOG - 1; i >= 0; i--)
            if ((diff & (1 << i)) != 0)
                a = parent[a][i];

        if (a == b) return a;

        for (int i = LOG - 1; i >= 0; i--) {
            if (parent[a][i] != parent[b][i]) {
                a = parent[a][i];
                b = parent[b][i];
            }
        }
        return parent[a][0];
    }

    public static void main(String[] args) {
        int n = 7;
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();

        adj[1].add(2); adj[2].add(1);
        adj[1].add(3); adj[3].add(1);
        adj[2].add(4); adj[4].add(2);
        adj[2].add(5); adj[5].add(2);
        adj[3].add(6); adj[6].add(3);
        adj[3].add(7); adj[7].add(3);

        dfs(1, 1, 0);
        preprocess(n);

        System.out.println("LCA(4,5) = " + lca(4,5));
        System.out.println("LCA(4,6) = " + lca(4,6));
    }
}

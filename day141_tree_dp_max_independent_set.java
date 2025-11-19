// day141_tree_dp_max_independent_set.java
// Maximum weighted independent set on a tree (choose nodes with no adjacent picks).
// Assumes tree is 0-indexed.

import java.util.*;

public class day141_tree_dp_max_independent_set {

    static List<List<Integer>> tree;
    static int[] value;
    static int[][] dp; // dp[node][0]=exclude, dp[node][1]=include
    static int[] parent;

    public static void dfs(int node, int par) {
        parent[node] = par;
        dp[node][0] = 0;
        dp[node][1] = value[node];

        for (int nei : tree.get(node)) {
            if (nei == par) continue;
            dfs(nei, node);
            dp[node][0] += Math.max(dp[nei][0], dp[nei][1]);
            dp[node][1] += dp[nei][0];
        }
    }

    public static List<Integer> reconstruct(int root) {
        List<Integer> chosen = new ArrayList<>();
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{root, (dp[root][1] >= dp[root][0]) ? 1 : 0});

        while (!stack.isEmpty()) {
            int[] cur = stack.pop();
            int node = cur[0], take = cur[1];
            if (take == 1) {
                chosen.add(node);
                for (int nei : tree.get(node)) {
                    if (nei == parent[node]) continue;
                    stack.push(new int[]{nei, 0});
                }
            } else {
                for (int nei : tree.get(node)) {
                    if (nei == parent[node]) continue;
                    int t = (dp[nei][1] >= dp[nei][0]) ? 1 : 0;
                    stack.push(new int[]{nei, t});
                }
            }
        }
        return chosen;
    }

    public static void main(String[] args) {
        int n = 7;
        value = new int[]{3, 2, 1, 10, 1, 3, 5}; // example node weights
        tree = new ArrayList<>();
        for (int i = 0; i < n; i++) tree.add(new ArrayList<>());

        // edges
        int[][] edges = {{0,1},{0,2},{1,3},{1,4},{2,5},{2,6}};
        for (int[] e : edges) {
            tree.get(e[0]).add(e[1]);
            tree.get(e[1]).add(e[0]);
        }

        dp = new int[n][2];
        parent = new int[n];
        Arrays.fill(parent, -1);

        dfs(0, -1);
        int best = Math.max(dp[0][0], dp[0][1]);
        System.out.println("Max weight of independent set: " + best);

        List<Integer> chosen = reconstruct(0);
        System.out.println("Chosen nodes: " + chosen);
    }
}

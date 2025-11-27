// Day148 Binary Lifting LCA (for trees) - preprocess O(n log n), query O(log n)
import java.util.*;
public class Day148BinaryLiftingLCA {
    static int LOG = 20;
    static List<List<Integer>> g;
    static int[][] up;
    static int[] depth;

    static void dfs(int v, int p){
        up[v][0] = p < 0 ? v : p;
        for(int i=1;i<LOG;i++) up[v][i] = up[ up[v][i-1] ][i-1];
        for(int to : g.get(v)){
            if(to == p) continue;
            depth[to] = depth[v] + 1;
            dfs(to, v);
        }
    }

    static int lca(int a, int b){
        if(depth[a] < depth[b]) { int t=a; a=b; b=t; }
        int diff = depth[a] - depth[b];
        for(int i=0;i<LOG;i++) if((diff & (1<<i)) != 0) a = up[a][i];
        if(a==b) return a;
        for(int i=LOG-1;i>=0;i--){
            if(up[a][i] != up[b][i]){
                a = up[a][i];
                b = up[b][i];
            }
        }
        return up[a][0];
    }

    public static void main(String[] args){
        int n = 9;
        g = new ArrayList<>();
        for(int i=0;i<n;i++) g.add(new ArrayList<>());
        // sample tree edges
        int[][] edges = {{0,1},{0,2},{1,3},{1,4},{2,5},{2,6},{4,7},{4,8}};
        for(int[] e: edges){
            g.get(e[0]).add(e[1]);
            g.get(e[1]).add(e[0]);
        }
        LOG = 20;
        up = new int[n][LOG];
        depth = new int[n];
        dfs(0, -1); // root at 0
        System.out.println("LCA of 7 and 8 = " + lca(7,8)); // 4
        System.out.println("LCA of 3 and 6 = " + lca(3,6)); // 0
    }
}

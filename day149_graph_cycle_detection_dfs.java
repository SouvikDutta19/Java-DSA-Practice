// Day149 Detect Cycle in Directed Graph using DFS
import java.util.*;

public class Day149GraphCycleDetectionDFS {

    static boolean dfs(int node, List<List<Integer>> g, boolean[] vis, boolean[] stack){
        vis[node] = true;
        stack[node] = true;

        for(int nxt : g.get(node)){
            if(!vis[nxt] && dfs(nxt, g, vis, stack)) return true;
            else if(stack[nxt]) return true;
        }
        stack[node] = false;
        return false;
    }

    static boolean hasCycle(int n, List<List<Integer>> g){
        boolean[] vis = new boolean[n];
        boolean[] stack = new boolean[n];

        for(int i=0;i<n;i++){
            if(!vis[i]){
                if(dfs(i, g, vis, stack)) return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        int n = 4;
        List<List<Integer>> g = new ArrayList<>();
        for(int i=0;i<n;i++) g.add(new ArrayList<>());
        
        g.get(0).add(1);
        g.get(1).add(2);
        g.get(2).add(0); // cycle
        g.get(2).add(3);

        System.out.println("Graph has cycle: " + hasCycle(n, g));
    }
}

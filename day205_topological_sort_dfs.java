import java.util.*;

public class day205_topological_sort_dfs {

    static void dfs(int node, boolean[] vis, Stack<Integer> st, List<List<Integer>> adj){
        vis[node] = true;
        for(int nei : adj.get(node))
            if(!vis[nei]) dfs(nei, vis, st, adj);
        st.push(node);
    }

    public static List<Integer> topoSort(int V, List<List<Integer>> adj){

        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<V;i++)
            if(!vis[i]) dfs(i, vis, st, adj);

        List<Integer> res = new ArrayList<>();
        while(!st.isEmpty()) res.add(st.pop());

        return res;
    }
}
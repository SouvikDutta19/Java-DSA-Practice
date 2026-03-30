import java.util.*;

public class day205_kosaraju_scc {

    static void dfs(int node, boolean[] vis, Stack<Integer> st, List<List<Integer>> adj){
        vis[node] = true;
        for(int nei : adj.get(node))
            if(!vis[nei]) dfs(nei, vis, st, adj);
        st.push(node);
    }

    static void dfsRev(int node, boolean[] vis, List<List<Integer>> rev){
        vis[node] = true;
        for(int nei : rev.get(node))
            if(!vis[nei]) dfsRev(nei, vis, rev);
    }

    public static int kosaraju(int V, List<List<Integer>> adj){

        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<V;i++)
            if(!vis[i]) dfs(i, vis, st, adj);

        List<List<Integer>> rev = new ArrayList<>();
        for(int i=0;i<V;i++) rev.add(new ArrayList<>());

        for(int i=0;i<V;i++)
            for(int j : adj.get(i))
                rev.get(j).add(i);

        Arrays.fill(vis, false);
        int count = 0;

        while(!st.isEmpty()){
            int node = st.pop();
            if(!vis[node]){
                dfsRev(node, vis, rev);
                count++;
            }
        }
        return count;
    }
}
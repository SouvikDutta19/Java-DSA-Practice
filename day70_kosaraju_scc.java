import java.util.*;

public class day70_kosaraju_scc {
    static void dfs1(int v, boolean[] vis, Stack<Integer> st, List<List<Integer>> adj) {
        vis[v]=true;
        for(int u:adj.get(v)) if(!vis[u]) dfs1(u,vis,st,adj);
        st.push(v);
    }

    static void dfs2(int v, boolean[] vis, List<List<Integer>> adj) {
        vis[v]=true; System.out.print(v+" ");
        for(int u:adj.get(v)) if(!vis[u]) dfs2(u,vis,adj);
    }

    public static void main(String[] args) {
        int n=5;
        List<List<Integer>> adj=new ArrayList<>(), rev=new ArrayList<>();
        for(int i=0;i<n;i++){adj.add(new ArrayList<>()); rev.add(new ArrayList<>());}
        adj.get(0).add(2); adj.get(2).add(1); adj.get(1).add(0);
        adj.get(0).add(3); adj.get(3).add(4);

        for(int i=0;i<n;i++) for(int v:adj.get(i)) rev.get(v).add(i);

        Stack<Integer> st=new Stack<>();
        boolean[] vis=new boolean[n];
        for(int i=0;i<n;i++) if(!vis[i]) dfs1(i,vis,st,adj);
        Arrays.fill(vis,false);
        while(!st.isEmpty()){
            int v=st.pop();
            if(!vis[v]){ dfs2(v,vis,rev); System.out.println(); }
        }
    }
}

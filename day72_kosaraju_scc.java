import java.util.*;

public class day72_kosaraju_scc {
    static List<Integer>[] adj, rev;
    static boolean[] vis;
    static Stack<Integer> st;

    static void dfs1(int u){
        vis[u]=true;
        for(int v:adj[u]) if(!vis[v]) dfs1(v);
        st.push(u);
    }
    static void dfs2(int u){
        vis[u]=true; System.out.print(u+" ");
        for(int v:rev[u]) if(!vis[v]) dfs2(v);
    }

    public static void main(String[] args){
        int n=5;
        adj=new ArrayList[n]; rev=new ArrayList[n];
        for(int i=0;i<n;i++){ adj[i]=new ArrayList<>(); rev[i]=new ArrayList<>(); }
        adj[1].add(0); rev[0].add(1);
        adj[0].add(2); rev[2].add(0);
        adj[2].add(1); rev[1].add(2);
        adj[0].add(3); rev[3].add(0);
        adj[3].add(4); rev[4].add(3);

        vis=new boolean[n]; st=new Stack<>();
        for(int i=0;i<n;i++) if(!vis[i]) dfs1(i);

        Arrays.fill(vis,false);
        while(!st.isEmpty()){
            int v=st.pop();
            if(!vis[v]){ dfs2(v); System.out.println(); }
        }
    }
}

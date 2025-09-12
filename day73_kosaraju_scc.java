import java.util.*;

public class day73_kosaraju_scc {
    static void dfs1(int u, boolean[] visited, Stack<Integer> st, List<List<Integer>> adj){
        visited[u]=true;
        for(int v: adj.get(u)) if(!visited[v]) dfs1(v,visited,st,adj);
        st.push(u);
    }
    static void dfs2(int u, boolean[] visited, List<List<Integer>> rev){
        visited[u]=true; System.out.print(u+" ");
        for(int v: rev.get(u)) if(!visited[v]) dfs2(v,visited,rev);
    }

    public static void main(String[] args){
        int n=5;
        List<List<Integer>> adj=new ArrayList<>(), rev=new ArrayList<>();
        for(int i=0;i<n;i++){adj.add(new ArrayList<>());rev.add(new ArrayList<>());}
        adj.get(1).add(0); adj.get(0).add(2); adj.get(2).add(1);
        adj.get(0).add(3); adj.get(3).add(4);
        for(int u=0;u<n;u++) for(int v:adj.get(u)) rev.get(v).add(u);

        Stack<Integer> st=new Stack<>();
        boolean[] visited=new boolean[n];
        for(int i=0;i<n;i++) if(!visited[i]) dfs1(i,visited,st,adj);

        Arrays.fill(visited,false);
        while(!st.isEmpty()){
            int v=st.pop();
            if(!visited[v]){ dfs2(v,visited,rev); System.out.println(); }
        }
    }
}

import java.util.*;

public class day68_articulation_points {
    static int time;
    static void dfs(int u,int p,List<List<Integer>> adj,boolean[] vis,int[] tin,int[] low,boolean[] ap){
        vis[u]=true; tin[u]=low[u]=++time;
        int children=0;
        for(int v:adj.get(u)){
            if(v==p) continue;
            if(vis[v]) low[u]=Math.min(low[u],tin[v]);
            else{
                dfs(v,u,adj,vis,tin,low,ap);
                low[u]=Math.min(low[u],low[v]);
                if(low[v]>=tin[u] && p!=-1) ap[u]=true;
                children++;
            }
        }
        if(p==-1 && children>1) ap[u]=true;
    }

    public static void main(String[] args){
        int n=5;
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        adj.get(0).add(1); adj.get(1).add(0);
        adj.get(1).add(2); adj.get(2).add(1);
        adj.get(1).add(3); adj.get(3).add(1);
        adj.get(3).add(4); adj.get(4).add(3);

        boolean[] vis=new boolean[n], ap=new boolean[n];
        int[] tin=new int[n], low=new int[n];
        time=0;
        for(int i=0;i<n;i++) if(!vis[i]) dfs(i,-1,adj,vis,tin,low,ap);
        for(int i=0;i<n;i++) if(ap[i]) System.out.println("Articulation Point: "+i);
    }
}

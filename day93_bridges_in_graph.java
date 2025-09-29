import java.util.*;

public class day93_bridges_in_graph {
    static int time=0;
    static void dfs(int u,int parent,boolean[] vis,int[] disc,int[] low,List<List<Integer>> g){
        vis[u]=true; disc[u]=low[u]=++time;
        for(int v:g.get(u)){
            if(v==parent) continue;
            if(!vis[v]){
                dfs(v,u,vis,disc,low,g);
                low[u]=Math.min(low[u],low[v]);
                if(low[v]>disc[u]) System.out.println(u+"-"+v+" is a bridge");
            } else low[u]=Math.min(low[u],disc[v]);
        }
    }
    public static void main(String[] args){
        int V=5;
        List<List<Integer>> g=new ArrayList<>();
        for(int i=0;i<V;i++) g.add(new ArrayList<>());
        g.get(0).add(1); g.get(1).add(0); g.get(0).add(2); g.get(2).add(0);
        g.get(1).add(2); g.get(2).add(1); g.get(1).add(3); g.get(3).add(1); g.get(3).add(4); g.get(4).add(3);
        boolean[] vis=new boolean[V];
        int[] disc=new int[V], low=new int[V];
        for(int i=0;i<V;i++) if(!vis[i]) dfs(i,-1,vis,disc,low,g);
    }
}

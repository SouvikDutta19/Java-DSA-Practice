import java.util.*;

public class day93_articulation_points {
    static int time=0;
    static void dfs(int u,int parent,boolean[] vis,int[] disc,int[] low,List<List<Integer>> g,boolean[] ap){
        vis[u]=true;
        disc[u]=low[u]=++time;
        int children=0;
        for(int v:g.get(u)){
            if(!vis[v]){
                children++;
                dfs(v,u,vis,disc,low,g,ap);
                low[u]=Math.min(low[u],low[v]);
                if(parent!=-1 && low[v]>=disc[u]) ap[u]=true;
            } else if(v!=parent) low[u]=Math.min(low[u],disc[v]);
        }
        if(parent==-1 && children>1) ap[u]=true;
    }
    public static void main(String[] args){
        int V=5;
        List<List<Integer>> g=new ArrayList<>();
        for(int i=0;i<V;i++) g.add(new ArrayList<>());
        g.get(1).add(0); g.get(0).add(1); g.get(0).add(2); g.get(2).add(0);
        g.get(0).add(3); g.get(3).add(0); g.get(3).add(4); g.get(4).add(3);
        boolean[] vis=new boolean[V], ap=new boolean[V];
        int[] disc=new int[V], low=new int[V];
        for(int i=0;i<V;i++) if(!vis[i]) dfs(i,-1,vis,disc,low,g,ap);
        System.out.println("Articulation Points:");
        for(int i=0;i<V;i++) if(ap[i]) System.out.print(i+" ");
    }
}

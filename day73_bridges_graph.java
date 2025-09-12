import java.util.*;

public class day73_bridges_graph {
    static int time=0;
    static void dfs(int u,int parent,List<List<Integer>> adj,int[] disc,int[] low){
        disc[u]=low[u]=++time;
        for(int v: adj.get(u)){
            if(disc[v]==-1){
                dfs(v,u,adj,disc,low);
                low[u]=Math.min(low[u],low[v]);
                if(low[v]>disc[u]) System.out.println(u+" - "+v+" is a bridge");
            } else if(v!=parent){
                low[u]=Math.min(low[u],disc[v]);
            }
        }
    }

    public static void main(String[] args){
        int n=5;
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        adj.get(0).addAll(Arrays.asList(1,2));
        adj.get(1).addAll(Arrays.asList(0,2));
        adj.get(2).addAll(Arrays.asList(0,1,3,4));
        adj.get(3).addAll(Arrays.asList(2,4));
        adj.get(4).addAll(Arrays.asList(2,3));

        int[] disc=new int[n],low=new int[n];
        Arrays.fill(disc,-1); Arrays.fill(low,-1);
        for(int i=0;i<n;i++) if(disc[i]==-1) dfs(i,-1,adj,disc,low);
    }
}

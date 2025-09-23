import java.util.*;

public class day88_articulation_points {
    static int time=0;
    static void dfs(int u, int parent, List<Integer>[] g, boolean[] visited, int[] disc, int[] low, boolean[] ap) {
        visited[u]=true;
        disc[u]=low[u]=++time;
        int children=0;
        for(int v:g[u]){
            if(!visited[v]){
                children++;
                dfs(v,u,g,visited,disc,low,ap);
                low[u]=Math.min(low[u],low[v]);
                if(parent!=-1 && low[v]>=disc[u]) ap[u]=true;
            } else if(v!=parent){
                low[u]=Math.min(low[u],disc[v]);
            }
        }
        if(parent==-1 && children>1) ap[u]=true;
    }

    public static void main(String[] args){
        int n=5;
        List<Integer>[] g=new ArrayList[n];
        for(int i=0;i<n;i++) g[i]=new ArrayList<>();
        g[0].add(1);g[1].add(0);
        g[0].add(2);g[2].add(0);
        g[1].add(2);g[2].add(1);
        g[1].add(3);g[3].add(1);
        g[3].add(4);g[4].add(3);

        boolean[] visited=new boolean[n],ap=new boolean[n];
        int[] disc=new int[n],low=new int[n];
        for(int i=0;i<n;i++) if(!visited[i]) dfs(i,-1,g,visited,disc,low,ap);
        System.out.print("Articulation points: ");
        for(int i=0;i<n;i++) if(ap[i]) System.out.print(i+" ");
    }
}

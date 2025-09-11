import java.util.*;

public class day72_lca_binary_lifting {
    static int LOG=20;
    static int[][] up;
    static int[] depth;
    static List<Integer>[] adj;

    static void dfs(int u,int p){
        up[u][0]=p;
        for(int i=1;i<LOG;i++) up[u][i]=up[up[u][i-1]][i-1];
        for(int v:adj[u]){
            if(v!=p){ depth[v]=depth[u]+1; dfs(v,u);}
        }
    }

    static int lca(int a,int b){
        if(depth[a]<depth[b]){int t=a;a=b;b=t;}
        int k=depth[a]-depth[b];
        for(int i=0;i<LOG;i++) if(((k>>i)&1)==1) a=up[a][i];
        if(a==b) return a;
        for(int i=LOG-1;i>=0;i--) if(up[a][i]!=up[b][i]){a=up[a][i];b=up[b][i];}
        return up[a][0];
    }

    public static void main(String[] args){
        int n=7;
        adj=new ArrayList[n];
        for(int i=0;i<n;i++) adj[i]=new ArrayList<>();
        adj[0].add(1); adj[1].add(0);
        adj[0].add(2); adj[2].add(0);
        adj[1].add(3); adj[3].add(1);
        adj[1].add(4); adj[4].add(1);
        adj[2].add(5); adj[5].add(2);
        adj[2].add(6); adj[6].add(2);

        depth=new int[n]; up=new int[n][LOG];
        dfs(0,0);
        System.out.println("LCA(3,4): "+lca(3,4));
        System.out.println("LCA(3,6): "+lca(3,6));
    }
}

import java.util.*;

public class day68_lca_binary_lifting {
    static int LOG=20,n;
    static int[][] up;
    static int[] depth;
    static List<List<Integer>> adj=new ArrayList<>();

    static void dfs(int u,int p){
        up[u][0]=p;
        for(int i=1;i<LOG;i++) up[u][i]=up[u][i-1]==-1?-1:up[up[u][i-1]][i-1];
        for(int v:adj.get(u)){
            if(v!=p){
                depth[v]=depth[u]+1;
                dfs(v,u);
            }
        }
    }

    static int lca(int a,int b){
        if(depth[a]<depth[b]){int t=a;a=b;b=t;}
        int diff=depth[a]-depth[b];
        for(int i=LOG-1;i>=0;i--) if(((diff>>i)&1)==1) a=up[a][i];
        if(a==b) return a;
        for(int i=LOG-1;i>=0;i--) if(up[a][i]!=up[b][i]){a=up[a][i]; b=up[b][i];}
        return up[a][0];
    }

    public static void main(String[] args){
        n=7;
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        adj.get(0).add(1); adj.get(1).add(0);
        adj.get(0).add(2); adj.get(2).add(0);
        adj.get(1).add(3); adj.get(3).add(1);
        adj.get(1).add(4); adj.get(4).add(1);
        adj.get(2).add(5); adj.get(5).add(2);
        adj.get(2).add(6); adj.get(6).add(2);

        depth=new int[n]; up=new int[n][LOG];
        for(int[] row:up) Arrays.fill(row,-1);
        dfs(0,-1);

        System.out.println("LCA of 3 and 4: "+lca(3,4));
        System.out.println("LCA of 3 and 5: "+lca(3,5));
    }
}

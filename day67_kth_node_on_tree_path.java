import java.io.*;
import java.util.*;

/**
 * LCA (binary lifting) + K-th node on path u->v.
 *
 * Input:
 * n
 * edges (n-1 lines) u v (1-indexed)
 * q
 * q lines: u v k -> find the k-th node (1-based) on path from u to v
 */
public class day67_kth_node_on_tree_path {
    static int N, LOG;
    static List<Integer>[] g;
    static int[] depth;
    static int[][] up;

    static void dfs(int v, int p){
        up[v][0]=p;
        for(int i=1;i<LOG;i++) up[v][i]= up[v][i-1]==0 ? 0 : up[up[v][i-1]][i-1];
        for(int u: g[v]) if(u!=p){
            depth[u]=depth[v]+1;
            dfs(u,v);
        }
    }

    static int lca(int a,int b){
        if(depth[a]<depth[b]){ int t=a;a=b;b=t; }
        int k=depth[a]-depth[b];
        for(int i=LOG-1;i>=0;i--) if(((k>>i)&1)==1) a=up[a][i];
        if(a==b) return a;
        for(int i=LOG-1;i>=0;i--) if(up[a][i]!=up[b][i]){ a=up[a][i]; b=up[b][i]; }
        return up[a][0];
    }

    static int kthAncestor(int v,int k){
        for(int i=0;i<LOG;i++) if(((k>>i)&1)==1) v=up[v][i];
        return v==0? -1 : v;
    }

    static int kthOnPath(int u,int v,int k){
        int w=lca(u,v);
        int len1=depth[u]-depth[w]+1; // nodes from u to w inclusive
        if(k<=len1) return kthAncestor(u, k-1);
        int k2 = k - len1;
        int len2=depth[v]-depth[w];   // nodes from child of w down to v
        // move from v up (len2 - k2) steps
        return kthAncestor(v, len2 - k2);
    }

    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine().trim());
        N=n; LOG=1; while((1<<LOG)<=n) LOG++;
        g=new ArrayList[n+1]; for(int i=1;i<=n;i++) g[i]=new ArrayList<>();
        for(int i=0;i<n-1;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken()), v=Integer.parseInt(st.nextToken());
            g[u].add(v); g[v].add(u);
        }
        depth=new int[n+1]; up=new int[n+1][LOG];
        dfs(1,0);

        int q=Integer.parseInt(br.readLine().trim());
        StringBuilder out=new StringBuilder();
        while(q-- > 0){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken()), v=Integer.parseInt(st.nextToken()), k=Integer.parseInt(st.nextToken());
            out.append(kthOnPath(u,v,k)).append('\n');
        }
        System.out.print(out.toString());
    }
}

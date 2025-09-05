import java.io.*;
import java.util.*;

/**
 * Euler Tour + Fenwick Tree:
 *  - Point update on a node's value
 *  - Subtree sum query
 *
 * Input:
 * n
 * values[1..n]
 * n-1 edges (u v)
 * q
 * q lines:
 *   1 u x   -> set value[u] = x
 *   2 u     -> sum of subtree(u)
 */
public class day67_euler_tour_subtree_fenwick {
    static List<Integer>[] g;
    static int timer=0;
    static int[] tin, tout, flat;
    static long[] val;

    static void dfs(int v,int p){
        tin[v]=++timer;
        flat[timer]=v;
        for(int u:g[v]) if(u!=p) dfs(u,v);
        tout[v]=timer;
    }

    static class Fenwick {
        long[] bit; int n;
        Fenwick(int n){ this.n=n; bit=new long[n+1]; }
        void add(int idx,long delta){ for(; idx<=n; idx+=idx&-idx) bit[idx]+=delta; }
        long sum(int idx){ long s=0; for(; idx>0; idx-=idx&-idx) s+=bit[idx]; return s; }
        long range(int l,int r){ return sum(r)-sum(l-1); }
    }

    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine().trim());
        val=new long[n+1];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++) val[i]=Long.parseLong(st.nextToken());
        g=new ArrayList[n+1];
        for(int i=1;i<=n;i++) g[i]=new ArrayList<>();
        for(int i=0;i<n-1;i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken()), v=Integer.parseInt(st.nextToken());
            g[u].add(v); g[v].add(u);
        }
        tin=new int[n+1]; tout=new int[n+1]; flat=new int[n+1];
        dfs(1,0);

        Fenwick fw=new Fenwick(n);
        for(int i=1;i<=n;i++) fw.add(tin[i], val[i]);

        int q=Integer.parseInt(br.readLine().trim());
        StringBuilder out=new StringBuilder();
        while(q-- > 0){
            st=new StringTokenizer(br.readLine());
            int t=Integer.parseInt(st.nextToken());
            if(t==1){
                int u=Integer.parseInt(st.nextToken());
                long x=Long.parseLong(st.nextToken());
                long cur = fw.range(tin[u], tin[u]);
                fw.add(tin[u], x - cur);
            }else{
                int u=Integer.parseInt(st.nextToken());
                out.append(fw.range(tin[u], tout[u])).append('\n');
            }
        }
        System.out.print(out.toString());
    }
}

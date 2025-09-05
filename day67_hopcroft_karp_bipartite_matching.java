import java.io.*;
import java.util.*;

/**
 * Hopcroft–Karp for Maximum Bipartite Matching.
 *
 * Input:
 * nL nR m
 * m lines: u v  (edge from left u to right v), 1-indexed
 * Output: maximum matching size
 */
public class day67_hopcroft_karp_bipartite_matching {
    static int nL, nR;
    static List<Integer>[] g;
    static int[] dist, matchL, matchR;

    static boolean bfs(){
        ArrayDeque<Integer> q=new ArrayDeque<>();
        Arrays.fill(dist, -1);
        for(int u=1;u<=nL;u++){
            if(matchL[u]==0){ dist[u]=0; q.add(u); }
        }
        boolean reachableFree=false;
        while(!q.isEmpty()){
            int u=q.poll();
            for(int v:g[u]){
                int mu=matchR[v];
                if(mu==0) reachableFree=true;
                else if(dist[mu]==-1){ dist[mu]=dist[u]+1; q.add(mu); }
            }
        }
        return reachableFree;
    }
    static boolean dfs(int u){
        for(int v:g[u]){
            int mu=matchR[v];
            if(mu==0 || (dist[mu]==dist[u]+1 && dfs(mu))){
                matchL[u]=v; matchR[v]=u; return true;
            }
        }
        dist[u]=-1; return false;
    }

    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        nL=Integer.parseInt(st.nextToken()); nR=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        g=new ArrayList[nL+1]; for(int i=1;i<=nL;i++) g[i]=new ArrayList<>();
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken()), v=Integer.parseInt(st.nextToken());
            g[u].add(v);
        }
        matchL=new int[nL+1]; matchR=new int[nR+1]; dist=new int[nL+1];

        int matching=0;
        while(bfs()){
            for(int u=1;u<=nL;u++) if(matchL[u]==0 && dfs(u)) matching++;
        }
        System.out.println(matching);
    }
}

import java.util.*;

public class day71_hopcroft_karp {
    static int NIL=0,INF=Integer.MAX_VALUE;
    static List<Integer>[] adj;
    static int[] pairU,pairV,dist;
    static int n,m;

    static boolean bfs(){
        Queue<Integer> q=new LinkedList<>();
        for(int u=1;u<=n;u++){
            if(pairU[u]==NIL){dist[u]=0;q.add(u);}
            else dist[u]=INF;
        }
        dist[NIL]=INF;
        while(!q.isEmpty()){
            int u=q.poll();
            if(dist[u]<dist[NIL]){
                for(int v:adj[u]){
                    if(dist[pairV[v]]==INF){
                        dist[pairV[v]]=dist[u]+1;
                        q.add(pairV[v]);
                    }
                }
            }
        }
        return dist[NIL]!=INF;
    }

    static boolean dfs(int u){
        if(u!=NIL){
            for(int v:adj[u]){
                if(dist[pairV[v]]==dist[u]+1 && dfs(pairV[v])){
                    pairV[v]=u; pairU[u]=v; return true;
                }
            }
            dist[u]=INF; return false;
        }
        return true;
    }

    static int hopcroftKarp(){
        pairU=new int[n+1]; pairV=new int[m+1]; dist=new int[n+1];
        int matching=0;
        while(bfs()){
            for(int u=1;u<=n;u++) if(pairU[u]==NIL && dfs(u)) matching++;
        }
        return matching;
    }

    public static void main(String[] args){
        n=4;m=4;
        adj=new ArrayList[n+1];
        for(int i=0;i<=n;i++) adj[i]=new ArrayList<>();
        adj[1].add(1); adj[1].add(2);
        adj[2].add(1); adj[3].add(2); adj[3].add(3);
        adj[4].add(2); adj[4].add(4);
        System.out.println("Maximum Matching: "+hopcroftKarp());
    }
}

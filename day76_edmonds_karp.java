import java.util.*;

public class day76_edmonds_karp {
    static final int V=6;

    static boolean bfs(int[][] rGraph,int s,int t,int[] parent){
        Arrays.fill(parent,-1);
        parent[s]=-2;
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{s,Integer.MAX_VALUE});
        while(!q.isEmpty()){
            int[] cur=q.poll(); int u=cur[0], flow=cur[1];
            for(int v=0;v<V;v++){
                if(parent[v]==-1 && rGraph[u][v]>0){
                    parent[v]=u;
                    int new_flow=Math.min(flow,rGraph[u][v]);
                    if(v==t) return true;
                    q.add(new int[]{v,new_flow});
                }
            }
        }
        return false;
    }

    static int edmondsKarp(int[][] graph,int s,int t){
        int[][] rGraph=new int[V][V];
        for(int i=0;i<V;i++) rGraph[i]=graph[i].clone();
        int[] parent=new int[V]; int max_flow=0;
        while(bfs(rGraph,s,t,parent)){
            int flow=Integer.MAX_VALUE;
            for(int v=t;v!=s;v=parent[v]) flow=Math.min(flow,rGraph[parent[v]][v]);
            for(int v=t;v!=s;v=parent[v]){
                int u=parent[v]; rGraph[u][v]-=flow; rGraph[v][u]+=flow;
            }
            max_flow+=flow;
        }
        return max_flow;
    }

    public static void main(String[] args){
        int[][] graph={{0,16,13,0,0,0},{0,0,10,12,0,0},
                       {0,4,0,0,14,0},{0,0,9,0,0,20},
                       {0,0,0,7,0,4},{0,0,0,0,0,0}};
        System.out.println("Max Flow: "+edmondsKarp(graph,0,5));
    }
}

import java.util.*;

public class day71_edmonds_karp_maxflow {
    static int bfs(int[][] rGraph,int s,int t,int[] parent){
        int V=rGraph.length;
        Arrays.fill(parent,-1);
        parent[s]=-2;
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{s,Integer.MAX_VALUE});
        while(!q.isEmpty()){
            int[] cur=q.poll(); int u=cur[0],flow=cur[1];
            for(int v=0;v<V;v++){
                if(parent[v]==-1 && rGraph[u][v]>0){
                    parent[v]=u;
                    int new_flow=Math.min(flow,rGraph[u][v]);
                    if(v==t) return new_flow;
                    q.add(new int[]{v,new_flow});
                }
            }
        }
        return 0;
    }

    static int maxflow(int[][] graph,int s,int t){
        int V=graph.length;
        int[][] rGraph=new int[V][V];
        for(int i=0;i<V;i++) rGraph[i]=Arrays.copyOf(graph[i],V);
        int flow=0,new_flow;
        int[] parent=new int[V];
        while((new_flow=bfs(rGraph,s,t,parent))>0){
            flow+=new_flow;
            int cur=t;
            while(cur!=s){
                int prev=parent[cur];
                rGraph[prev][cur]-=new_flow;
                rGraph[cur][prev]+=new_flow;
                cur=prev;
            }
        }
        return flow;
    }

    public static void main(String[] args){
        int[][] graph={
            {0,16,13,0,0,0},
            {0,0,10,12,0,0},
            {0,4,0,0,14,0},
            {0,0,9,0,0,20},
            {0,0,0,7,0,4},
            {0,0,0,0,0,0}
        };
        System.out.println("Max Flow: "+maxflow(graph,0,5));
    }
}

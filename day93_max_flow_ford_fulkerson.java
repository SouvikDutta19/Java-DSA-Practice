import java.util.*;

public class day93_max_flow_ford_fulkerson {
    static boolean bfs(int[][] rGraph,int s,int t,int[] parent){
        boolean[] vis=new boolean[rGraph.length];
        Queue<Integer> q=new LinkedList<>();
        q.add(s); vis[s]=true; parent[s]=-1;
        while(!q.isEmpty()){
            int u=q.poll();
            for(int v=0;v<rGraph.length;v++){
                if(!vis[v] && rGraph[u][v]>0){
                    parent[v]=u; vis[v]=true; q.add(v);
                }
            }
        }
        return vis[t];
    }
    static int fordFulkerson(int[][] graph,int s,int t){
        int u,v;
        int[][] rGraph=new int[graph.length][graph.length];
        for(u=0;u<graph.length;u++) for(v=0;v<graph.length;v++) rGraph[u][v]=graph[u][v];
        int[] parent=new int[graph.length]; int max_flow=0;
        while(bfs(rGraph,s,t,parent)){
            int path_flow=Integer.MAX_VALUE;
            for(v=t;v!=s;v=parent[v]){
                u=parent[v]; path_flow=Math.min(path_flow,rGraph[u][v]);
            }
            for(v=t;v!=s;v=parent[v]){
                u=parent[v]; rGraph[u][v]-=path_flow; rGraph[v][u]+=path_flow;
            }
            max_flow+=path_flow;
        }
        return max_flow;
    }
    public static void main(String[] args){
        int[][] graph={{0,16,13,0,0,0},{0,0,10,12,0,0},{0,4,0,0,14,0},{0,0,9,0,0,20},{0,0,0,7,0,4},{0,0,0,0,0,0}};
        System.out.println("Max Flow: "+fordFulkerson(graph,0,5));
    }
}

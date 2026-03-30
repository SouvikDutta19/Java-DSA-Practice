import java.util.*;

public class day205_bellman_ford {

    static class Edge{
        int u,v,w;
        Edge(int u,int v,int w){this.u=u;this.v=v;this.w=w;}
    }

    public static int[] bellmanFord(int V, List<Edge> edges, int src){

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for(int i=1;i<V;i++){
            for(Edge e : edges){
                if(dist[e.u] != Integer.MAX_VALUE &&
                   dist[e.u] + e.w < dist[e.v]){
                    dist[e.v] = dist[e.u] + e.w;
                }
            }
        }
        return dist;
    }
}
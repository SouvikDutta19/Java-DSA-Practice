import java.util.*;

public class day71_johnson_apsp {
    static class Edge {int u,v,w;Edge(int u,int v,int w){this.u=u;this.v=v;this.w=w;}}
    static final int INF=1000000;

    public static void main(String[] args){
        int V=5;
        List<Edge> edges=new ArrayList<>();
        edges.add(new Edge(0,1,-1));
        edges.add(new Edge(0,2,4));
        edges.add(new Edge(1,2,3));
        edges.add(new Edge(1,3,2));
        edges.add(new Edge(1,4,2));
        edges.add(new Edge(3,2,5));
        edges.add(new Edge(3,1,1));
        edges.add(new Edge(4,3,-3));

        int[] h=new int[V]; Arrays.fill(h,0);
        for(int i=0;i<V-1;i++)
            for(Edge e:edges) if(h[e.u]+e.w<h[e.v]) h[e.v]=h[e.u]+e.w;

        int[][] dist=new int[V][V];
        for(int u=0;u<V;u++){
            Arrays.fill(dist[u],INF); dist[u][u]=0;
            PriorityQueue<int[]> pq=new PriorityQueue<>(Comparator.comparingInt(a->a[1]));
            pq.add(new int[]{u,0});
            while(!pq.isEmpty()){
                int[] cur=pq.poll(); int node=cur[0],d=cur[1];
                if(d>dist[u][node]) continue;
                for(Edge e:edges){
                    if(e.u==node){
                        int nd=d+e.w+h[e.u]-h[e.v];
                        if(nd<dist[u][e.v]){
                            dist[u][e.v]=nd; pq.add(new int[]{e.v,nd});
                        }
                    }
                }
            }
        }
        for(int i=0;i<V;i++) System.out.println(Arrays.toString(dist[i]));
    }
}

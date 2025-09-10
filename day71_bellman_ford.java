import java.util.*;

public class day71_bellman_ford {
    static class Edge { int u,v,w; Edge(int u,int v,int w){this.u=u;this.v=v;this.w=w;} }

    public static void main(String[] args){
        int V=5, E=8;
        List<Edge> edges=new ArrayList<>();
        edges.add(new Edge(0,1,-1));
        edges.add(new Edge(0,2,4));
        edges.add(new Edge(1,2,3));
        edges.add(new Edge(1,3,2));
        edges.add(new Edge(1,4,2));
        edges.add(new Edge(3,2,5));
        edges.add(new Edge(3,1,1));
        edges.add(new Edge(4,3,-3));

        int[] dist=new int[V];
        Arrays.fill(dist,1000000); dist[0]=0;

        for(int i=1;i<V;i++){
            for(Edge e:edges){
                if(dist[e.u]+e.w<dist[e.v]) dist[e.v]=dist[e.u]+e.w;
            }
        }

        for(Edge e:edges){
            if(dist[e.u]+e.w<dist[e.v]) System.out.println("Negative cycle detected!");
        }

        System.out.println(Arrays.toString(dist));
    }
}

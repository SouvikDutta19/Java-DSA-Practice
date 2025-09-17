import java.util.*;

class Edge {
    int src,dest,weight;
    Edge(int s,int d,int w){src=s;dest=d;weight=w;}
}

public class day81_bellman_ford {
    public static void bellmanFord(int V,int E,List<Edge> edges,int src){
        int[] dist=new int[V];
        Arrays.fill(dist,99999);
        dist[src]=0;
        for(int i=1;i<V;i++) {
            for(Edge e:edges) {
                if(dist[e.src]+e.weight<dist[e.dest])
                    dist[e.dest]=dist[e.src]+e.weight;
            }
        }
        for(Edge e:edges) {
            if(dist[e.src]+e.weight<dist[e.dest]) {
                System.out.println("Graph contains negative cycle");
                return;
            }
        }
        System.out.println("Shortest distances: "+Arrays.toString(dist));
    }

    public static void main(String[] args) {
        List<Edge> edges=new ArrayList<>();
        edges.add(new Edge(0,1,-1));
        edges.add(new Edge(0,2,4));
        edges.add(new Edge(1,2,3));
        edges.add(new Edge(1,3,2));
        edges.add(new Edge(1,4,2));
        edges.add(new Edge(3,2,5));
        edges.add(new Edge(3,1,1));
        edges.add(new Edge(4,3,-3));
        bellmanFord(5,8,edges,0);
    }
}

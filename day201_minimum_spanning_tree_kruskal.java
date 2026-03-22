import java.util.*;

public class day201_minimum_spanning_tree_kruskal {

    static class Edge {
        int u,v,w;
        Edge(int u,int v,int w){
            this.u=u; this.v=v; this.w=w;
        }
    }

    static int[] parent;

    static int find(int x){
        if(parent[x]!=x)
            parent[x]=find(parent[x]);
        return parent[x];
    }

    static void union(int x,int y){
        parent[find(x)] = find(y);
    }

    public static void main(String[] args){

        int V = 4;

        Edge[] edges = {
                new Edge(0,1,10),
                new Edge(0,2,6),
                new Edge(0,3,5),
                new Edge(1,3,15),
                new Edge(2,3,4)
        };

        Arrays.sort(edges, Comparator.comparingInt(e -> e.w));

        parent = new int[V];
        for(int i=0;i<V;i++) parent[i]=i;

        int mstWeight = 0;

        for(Edge e : edges){
            if(find(e.u) != find(e.v)){
                union(e.u,e.v);
                mstWeight += e.w;
            }
        }

        System.out.println("MST Weight: " + mstWeight);
    }
}
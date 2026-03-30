import java.util.*;

public class day205_minimum_spanning_tree_kruskal {

    static class Edge{
        int u,v,w;
        Edge(int u,int v,int w){this.u=u;this.v=v;this.w=w;}
    }

    static int[] parent;

    static int find(int x){
        if(parent[x]==x) return x;
        return parent[x]=find(parent[x]);
    }

    static void union(int a,int b){
        a=find(a); b=find(b);
        if(a!=b) parent[a]=b;
    }

    public static int kruskal(int V, List<Edge> edges){

        Collections.sort(edges, (a,b)->a.w-b.w);
        parent = new int[V];
        for(int i=0;i<V;i++) parent[i]=i;

        int cost = 0;

        for(Edge e : edges){
            if(find(e.u)!=find(e.v)){
                cost += e.w;
                union(e.u,e.v);
            }
        }
        return cost;
    }
}
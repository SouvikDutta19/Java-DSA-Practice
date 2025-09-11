import java.util.*;

class Edge implements Comparable<Edge>{
    int u,v,w;
    Edge(int u,int v,int w){this.u=u;this.v=v;this.w=w;}
    public int compareTo(Edge o){return this.w-o.w;}
}

public class day72_kruskal_mst {
    static int[] parent,rank;
    static int find(int x){return parent[x]==x?x:(parent[x]=find(parent[x]));}
    static void union(int x,int y){
        int rx=find(x), ry=find(y);
        if(rx!=ry){ if(rank[rx]<rank[ry]) parent[rx]=ry;
        else if(rank[ry]<rank[rx]) parent[ry]=rx; else {parent[ry]=rx;rank[rx]++;} }
    }

    public static void main(String[] args){
        int V=4;
        parent=new int[V]; rank=new int[V];
        for(int i=0;i<V;i++) parent[i]=i;
        List<Edge> edges=new ArrayList<>();
        edges.add(new Edge(0,1,10));
        edges.add(new Edge(0,2,6));
        edges.add(new Edge(0,3,5));
        edges.add(new Edge(1,3,15));
        edges.add(new Edge(2,3,4));
        Collections.sort(edges);
        int mst=0;
        for(Edge e:edges){
            if(find(e.u)!=find(e.v)){ mst+=e.w; union(e.u,e.v);}
        }
        System.out.println("MST weight: "+mst);
    }
}

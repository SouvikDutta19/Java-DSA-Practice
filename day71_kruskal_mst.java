import java.util.*;

public class day71_kruskal_mst {
    static class Edge implements Comparable<Edge> {
        int u,v,w;
        Edge(int u,int v,int w){this.u=u;this.v=v;this.w=w;}
        public int compareTo(Edge e){return this.w-e.w;}
    }
    static int find(int[] parent,int x){return parent[x]==x?x:(parent[x]=find(parent,parent[x]));}
    static void union(int[] parent,int[] rank,int a,int b){
        a=find(parent,a); b=find(parent,b);
        if(a!=b){ if(rank[a]<rank[b]) parent[a]=b;
                  else if(rank[b]<rank[a]) parent[b]=a;
                  else {parent[b]=a; rank[a]++;}}
    }

    public static void main(String[] args){
        int V=4;
        List<Edge> edges=new ArrayList<>();
        edges.add(new Edge(0,1,10));
        edges.add(new Edge(0,2,6));
        edges.add(new Edge(0,3,5));
        edges.add(new Edge(1,3,15));
        edges.add(new Edge(2,3,4));

        Collections.sort(edges);
        int[] parent=new int[V],rank=new int[V];
        for(int i=0;i<V;i++) parent[i]=i;
        int cost=0;
        for(Edge e:edges){
            if(find(parent,e.u)!=find(parent,e.v)){
                union(parent,rank,e.u,e.v);
                cost+=e.w;
                System.out.println("Edge: "+e.u+" - "+e.v);
            }
        }
        System.out.println("MST Cost: "+cost);
    }
}

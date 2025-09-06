import java.io.*;
import java.util.*;

public class day67_kruskal_mst {
    static class Edge implements Comparable<Edge> {
        int u, v, w;
        Edge(int u, int v, int w) { this.u = u; this.v = v; this.w = w; }
        public int compareTo(Edge other) { return this.w - other.w; }
    }

    static class DSU {
        int[] parent, rank;
        DSU(int n) { parent = new int[n]; rank = new int[n]; for (int i=0;i<n;i++) parent[i]=i; }
        int find(int x) { return parent[x]==x?x:(parent[x]=find(parent[x])); }
        boolean union(int a,int b) {
            a=find(a); b=find(b);
            if(a==b) return false;
            if(rank[a]<rank[b]) parent[a]=b;
            else if(rank[b]<rank[a]) parent[b]=a;
            else { parent[b]=a; rank[a]++; }
            return true;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        List<Edge> edges = new ArrayList<>();
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken()), v=Integer.parseInt(st.nextToken()), w=Integer.parseInt(st.nextToken());
            edges.add(new Edge(u,v,w));
        }
        Collections.sort(edges);
        DSU dsu = new DSU(n);
        int mst=0;
        for(Edge e: edges) if(dsu.union(e.u,e.v)) mst+=e.w;
        System.out.println(mst);
    }
}

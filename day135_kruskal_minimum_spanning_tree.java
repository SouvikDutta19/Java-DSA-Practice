// day135_kruskal_minimum_spanning_tree.java
// Kruskal's MST using Union-Find

import java.util.*;

class EdgeK implements Comparable<EdgeK> {
    int u, v, w;
    EdgeK(int u, int v, int w) { this.u = u; this.v = v; this.w = w; }
    public int compareTo(EdgeK other) { return this.w - other.w; }
}

class DSU {
    int[] parent, rank;
    DSU(int n) { parent = new int[n]; rank = new int[n]; for (int i=0;i<n;i++) parent[i]=i; }
    int find(int x) { return parent[x]==x?x:(parent[x]=find(parent[x])); }
    void union(int a, int b) {
        a = find(a); b = find(b);
        if (a==b) return;
        if (rank[a]<rank[b]) parent[a]=b;
        else if (rank[a]>rank[b]) parent[b]=a;
        else { parent[b]=a; rank[a]++; }
    }
}

public class day135_kruskal_minimum_spanning_tree {
    static void kruskal(int V, List<EdgeK> edges) {
        Collections.sort(edges);
        DSU dsu = new DSU(V);
        int mstWeight = 0;
        List<EdgeK> mst = new ArrayList<>();
        for (EdgeK e : edges) {
            if (dsu.find(e.u) != dsu.find(e.v)) {
                dsu.union(e.u, e.v);
                mst.add(e);
                mstWeight += e.w;
            }
        }
        System.out.println("Edges in MST:");
        for (EdgeK e : mst) System.out.println(e.u + " - " + e.v + " : " + e.w);
        System.out.println("Total weight: " + mstWeight);
    }

    public static void main(String[] args) {
        int V = 4;
        List<EdgeK> edges = Arrays.asList(
            new EdgeK(0,1,10), new EdgeK(0,2,6), new EdgeK(0,3,5),
            new EdgeK(1,3,15), new EdgeK(2,3,4)
        );
        kruskal(V, edges);
    }
}

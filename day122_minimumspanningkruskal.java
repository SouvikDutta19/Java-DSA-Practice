// day122_minimumspanningkruskal.java
import java.util.*;

public class day122_minimumspanningkruskal {
    static class Edge implements Comparable<Edge> {
        int src, dest, weight;
        Edge(int s, int d, int w) { src = s; dest = d; weight = w; }
        public int compareTo(Edge e) { return this.weight - e.weight; }
    }

    static class DisjointSet {
        int[] parent, rank;
        DisjointSet(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int x, int y) {
            int xr = find(x), yr = find(y);
            if (xr == yr) return;
            if (rank[xr] < rank[yr]) parent[xr] = yr;
            else if (rank[xr] > rank[yr]) parent[yr] = xr;
            else { parent[yr] = xr; rank[xr]++; }
        }
    }

    public static void main(String[] args) {
        int V = 4;
        Edge[] edges = {
            new Edge(0,1,10),
            new Edge(0,2,6),
            new Edge(0,3,5),
            new Edge(1,3,15),
            new Edge(2,3,4)
        };

        Arrays.sort(edges);
        DisjointSet ds = new DisjointSet(V);
        int cost = 0;
        for (Edge e : edges) {
            if (ds.find(e.src) != ds.find(e.dest)) {
                ds.union(e.src, e.dest);
                cost += e.weight;
            }
        }
        System.out.println("Total weight of MST: " + cost);
    }
}

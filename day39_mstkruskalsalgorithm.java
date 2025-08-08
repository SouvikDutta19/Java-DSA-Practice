// Kruskal's Algorithm for Minimum Spanning Tree using Union-Find

import java.util.*;

class Edge implements Comparable<Edge> {
    int src, dest, weight;
    Edge(int s, int d, int w) {
        src = s; dest = d; weight = w;
    }

    public int compareTo(Edge e) {
        return this.weight - e.weight;
    }
}

class DisjointSet {
    int[] parent, rank;

    DisjointSet(int n) {
        parent = new int[n]; rank = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
    }

    int find(int u) {
        if (parent[u] != u)
            parent[u] = find(parent[u]);
        return parent[u];
    }

    void union(int u, int v) {
        int pu = find(u);
        int pv = find(v);
        if (pu != pv) {
            if (rank[pu] < rank[pv])
                parent[pu] = pv;
            else if (rank[pu] > rank[pv])
                parent[pv] = pu;
            else {
                parent[pv] = pu;
                rank[pu]++;
            }
        }
    }
}

public class day39_mstkruskalsalgorithm {
    public static void main(String[] args) {
        int V = 4;
        List<Edge> edges = List.of(
            new Edge(0, 1, 10),
            new Edge(0, 2, 6),
            new Edge(0, 3, 5),
            new Edge(1, 3, 15),
            new Edge(2, 3, 4)
        );

        Collections.sort(edges);
        DisjointSet ds = new DisjointSet(V);
        int mstWeight = 0;

        for (Edge edge : edges) {
            if (ds.find(edge.src) != ds.find(edge.dest)) {
                ds.union(edge.src, edge.dest);
                mstWeight += edge.weight;
                System.out.println("Edge included: " + edge.src + " - " + edge.dest + " (" + edge.weight + ")");
            }
        }

        System.out.println("Total weight of MST: " + mstWeight);
    }
}

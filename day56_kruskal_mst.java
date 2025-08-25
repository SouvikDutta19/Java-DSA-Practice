import java.util.*;

class Edge implements Comparable<Edge> {
    int src, dest, weight;

    Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }
}

class DisjointSetKruskal {
    int[] parent, rank;

    DisjointSetKruskal(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
    }

    int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    void union(int x, int y) {
        int rootX = find(x), rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] < rank[rootY]) parent[rootX] = rootY;
            else if (rank[rootX] > rank[rootY]) parent[rootY] = rootX;
            else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }
}

public class day56_kruskal_mst {
    public static void main(String[] args) {
        int vertices = 4;
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 6));
        edges.add(new Edge(0, 3, 5));
        edges.add(new Edge(1, 3, 15));
        edges.add(new Edge(2, 3, 4));

        Collections.sort(edges);
        DisjointSetKruskal ds = new DisjointSetKruskal(vertices);

        List<Edge> mst = new ArrayList<>();
        for (Edge e : edges) {
            if (ds.find(e.src) != ds.find(e.dest)) {
                mst.add(e);
                ds.union(e.src, e.dest);
            }
        }

        System.out.println("Edges in MST using Kruskal's Algorithm:");
        for (Edge e : mst) {
            System.out.println(e.src + " - " + e.dest + " : " + e.weight);
        }
    }
}

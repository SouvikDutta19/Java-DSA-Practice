import java.util.*;

class Edge {
    int src, dest, weight;
    Edge(int s, int d, int w) {
        src = s; dest = d; weight = w;
    }
}

class DSU {
    int[] parent, rank;

    DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
    }

    int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa != pb) {
            if (rank[pa] < rank[pb]) parent[pa] = pb;
            else if (rank[pb] < rank[pa]) parent[pb] = pa;
            else {
                parent[pb] = pa;
                rank[pa]++;
            }
        }
    }
}

public class day143_kruskal_mst {

    public static void kruskalMST(List<Edge> edges, int n) {
        edges.sort(Comparator.comparingInt(a -> a.weight));

        DSU dsu = new DSU(n);

        List<Edge> mst = new ArrayList<>();
        int totalWeight = 0;

        for (Edge e : edges) {
            int ps = dsu.find(e.src);
            int pd = dsu.find(e.dest);

            if (ps != pd) {
                mst.add(e);
                totalWeight += e.weight;
                dsu.union(ps, pd);
            }
        }

        System.out.println("Kruskal MST:");
        for (Edge e : mst)
            System.out.println(e.src + " - " + e.dest + " : " + e.weight);

        System.out.println("Total Weight = " + totalWeight);
    }

    public static void main(String[] args) {
        List<Edge> edges = Arrays.asList(
                new Edge(0, 1, 10),
                new Edge(0, 2, 6),
                new Edge(0, 3, 5),
                new Edge(1, 3, 15),
                new Edge(2, 3, 4)
        );
        kruskalMST(edges, 4);
    }
}

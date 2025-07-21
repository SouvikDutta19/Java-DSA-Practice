import java.util.*;

public class day21_minimum_spanning_kruskal {
    static class Edge implements Comparable<Edge> {
        int src, dest, weight;

        Edge(int s, int d, int w) {
            src = s; dest = d; weight = w;
        }

        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }
    }

    static class DSU {
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

        void union(int x, int y) {
            int px = find(x), py = find(y);
            if (px != py) {
                if (rank[px] < rank[py]) parent[px] = py;
                else if (rank[px] > rank[py]) parent[py] = px;
                else {
                    parent[py] = px;
                    rank[px]++;
                }
            }
        }
    }

    public static void main(String[] args) {
        int V = 4;
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 6));
        edges.add(new Edge(0, 3, 5));
        edges.add(new Edge(1, 3, 15));
        edges.add(new Edge(2, 3, 4));

        Collections.sort(edges);
        DSU dsu = new DSU(V);
        int mstWeight = 0;

        for (Edge e : edges) {
            if (dsu.find(e.src) != dsu.find(e.dest)) {
                dsu.union(e.src, e.dest);
                mstWeight += e.weight;
                System.out.println("Edge: " + e.src + " - " + e.dest);
            }
        }

        System.out.println("Total weight of MST: " + mstWeight);
    }
}

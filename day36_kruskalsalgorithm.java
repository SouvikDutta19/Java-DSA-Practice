import java.util.*;

public class day36_kruskalsalgorithm {
    static class Edge implements Comparable<Edge> {
        int u, v, weight;
        Edge(int u, int v, int w) { this.u = u; this.v = v; this.weight = w; }

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
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }

        boolean union(int x, int y) {
            int px = find(x), py = find(y);
            if (px == py) return false;
            if (rank[px] < rank[py]) parent[px] = py;
            else if (rank[py] < rank[px]) parent[py] = px;
            else {
                parent[py] = px;
                rank[px]++;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        int V = 4;
        List<Edge> edges = Arrays.asList(
            new Edge(0, 1, 10),
            new Edge(0, 2, 6),
            new Edge(0, 3, 5),
            new Edge(1, 3, 15),
            new Edge(2, 3, 4)
        );

        Collections.sort(edges);
        DSU dsu = new DSU(V);

        int mstWeight = 0;
        for (Edge edge : edges) {
            if (dsu.union(edge.u, edge.v)) {
                mstWeight += edge.weight;
                System.out.println("Edge added: " + edge.u + " - " + edge.v + " (Weight: " + edge.weight + ")");
            }
        }

        System.out.println("Total MST weight: " + mstWeight);
    }
}

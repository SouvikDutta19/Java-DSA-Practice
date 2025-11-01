// day125_minimum_spanning_tree_kruskal.java
import java.util.*;

class Edge {
    int src, dest, wt;
    Edge(int s, int d, int w) { src = s; dest = d; wt = w; }
}

class DisjointSet {
    int[] parent, rank;
    DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
    }

    int find(int x) {
        if (x != parent[x]) parent[x] = find(parent[x]);
        return parent[x];
    }

    void union(int x, int y) {
        int px = find(x), py = find(y);
        if (px == py) return;
        if (rank[px] < rank[py]) parent[px] = py;
        else if (rank[px] > rank[py]) parent[py] = px;
        else {
            parent[py] = px;
            rank[px]++;
        }
    }
}

public class day125_minimum_spanning_tree_kruskal {
    static void kruskalMST(int V, List<Edge> edges) {
        Collections.sort(edges, Comparator.comparingInt(a -> a.wt));
        DisjointSet ds = new DisjointSet(V);
        int total = 0;

        for (Edge e : edges) {
            if (ds.find(e.src) != ds.find(e.dest)) {
                ds.union(e.src, e.dest);
                total += e.wt;
            }
        }
        System.out.println("Total weight of MST: " + total);
    }

    public static void main(String[] args) {
        List<Edge> edges = Arrays.asList(
            new Edge(0,1,10), new Edge(0,2,6), new Edge(0,3,5), new Edge(1,3,15), new Edge(2,3,4)
        );
        kruskalMST(4, edges);
    }
}

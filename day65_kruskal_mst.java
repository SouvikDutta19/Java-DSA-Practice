import java.util.*;

public class day65_kruskal_mst {
    static class Edge implements Comparable<Edge> {
        int src, dest, weight;
        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    }

    static class Subset {
        int parent, rank;
    }

    static int find(Subset[] subsets, int i) {
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);
        return subsets[i].parent;
    }

    static void union(Subset[] subsets, int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;
        else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    static void KruskalMST(int V, Edge[] edges) {
        Arrays.sort(edges);
        Subset[] subsets = new Subset[V];
        for (int v = 0; v < V; ++v) {
            subsets[v] = new Subset();
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }

        List<Edge> result = new ArrayList<>();
        for (Edge edge : edges) {
            int x = find(subsets, edge.src);
            int y = find(subsets, edge.dest);
            if (x != y) {
                result.add(edge);
                union(subsets, x, y);
            }
        }

        System.out.println("Edges in MST:");
        for (Edge e : result)
            System.out.println(e.src + " - " + e.dest + " : " + e.weight);
    }

    public static void main(String[] args) {
        int V = 4;
        Edge[] edges = new Edge[5];
        for (int i = 0; i < 5; i++) edges[i] = new Edge();
        edges[0].src = 0; edges[0].dest = 1; edges[0].weight = 10;
        edges[1].src = 0; edges[1].dest = 2; edges[1].weight = 6;
        edges[2].src = 0; edges[2].dest = 3; edges[2].weight = 5;
        edges[3].src = 1; edges[3].dest = 3; edges[3].weight = 15;
        edges[4].src = 2; edges[4].dest = 3; edges[4].weight = 4;

        KruskalMST(V, edges);
    }
}

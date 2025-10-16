import java.util.*;

class Edge implements Comparable<Edge> {
    int src, dest, weight;
    public Edge(int s, int d, int w) {
        src = s; dest = d; weight = w;
    }

    public int compareTo(Edge e) {
        return this.weight - e.weight;
    }
}

class Subset {
    int parent, rank;
    public Subset(int p, int r) {
        parent = p; rank = r;
    }
}

public class day110_kruskals_minimum_spanning_tree {

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

    static void kruskalMST(int V, List<Edge> edges) {
        Collections.sort(edges);
        Subset[] subsets = new Subset[V];
        for (int v = 0; v < V; ++v)
            subsets[v] = new Subset(v, 0);

        List<Edge> result = new ArrayList<>();
        int e = 0, i = 0;

        while (e < V - 1 && i < edges.size()) {
            Edge next_edge = edges.get(i++);
            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);

            if (x != y) {
                result.add(next_edge);
                union(subsets, x, y);
                e++;
            }
        }

        System.out.println("Edges in Minimum Spanning Tree:");
        for (Edge edge : result)
            System.out.println(edge.src + " -- " + edge.dest + " == " + edge.weight);
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
        kruskalMST(V, edges);
    }
}

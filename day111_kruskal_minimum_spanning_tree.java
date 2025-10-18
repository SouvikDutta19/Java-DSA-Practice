// Program to find Minimum Spanning Tree using Kruskal's Algorithm

import java.util.*;

class EdgeK {
    int src, dest, weight;
    EdgeK(int s, int d, int w) { src = s; dest = d; weight = w; }
}

class Subset {
    int parent, rank;
}

public class day111_kruskal_minimum_spanning_tree {
    int V;
    List<EdgeK> edges = new ArrayList<>();

    day111_kruskal_minimum_spanning_tree(int v) { V = v; }

    void addEdge(int s, int d, int w) { edges.add(new EdgeK(s, d, w)); }

    int find(Subset[] subsets, int i) {
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);
        return subsets[i].parent;
    }

    void union(Subset[] subsets, int x, int y) {
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

    void kruskalMST() {
        List<EdgeK> result = new ArrayList<>();
        edges.sort(Comparator.comparingInt(e -> e.weight));

        Subset[] subsets = new Subset[V];
        for (int v = 0; v < V; v++) {
            subsets[v] = new Subset();
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }

        int e = 0, i = 0;
        while (e < V - 1 && i < edges.size()) {
            EdgeK nextEdge = edges.get(i++);
            int x = find(subsets, nextEdge.src);
            int y = find(subsets, nextEdge.dest);

            if (x != y) {
                result.add(nextEdge);
                union(subsets, x, y);
                e++;
            }
        }

        System.out.println("Edges in the constructed MST:");
        for (EdgeK edge : result)
            System.out.println(edge.src + " -- " + edge.dest + " == " + edge.weight);
    }

    public static void main(String[] args) {
        day111_kruskal_minimum_spanning_tree graph = new day111_kruskal_minimum_spanning_tree(4);
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 2, 6);
        graph.addEdge(0, 3, 5);
        graph.addEdge(1, 3, 15);
        graph.addEdge(2, 3, 4);

        graph.kruskalMST();
    }
}

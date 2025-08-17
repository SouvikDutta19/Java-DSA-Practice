import java.util.*;

class Edge implements Comparable<Edge> {
    int src, dest, weight;
    public int compareTo(Edge compareEdge) {
        return this.weight - compareEdge.weight;
    }
}

class Subset {
    int parent, rank;
}

public class day48_minimum_spanning_tree_kruskal {
    int V, E;
    Edge[] edges;

    day48_minimum_spanning_tree_kruskal(int v, int e) {
        V = v;
        E = e;
        edges = new Edge[E];
        for (int i = 0; i < e; i++) edges[i] = new Edge();
    }

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

    void KruskalMST() {
        Edge[] result = new Edge[V];
        int e = 0;
        for (int i = 0; i < V; i++) result[i] = new Edge();
        Arrays.sort(edges);

        Subset[] subsets = new Subset[V];
        for (int v = 0; v < V; ++v) {
            subsets[v] = new Subset();
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }

        int i = 0;
        while (e < V - 1 && i < E) {
            Edge next_edge = edges[i++];
            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);

            if (x != y) {
                result[e++] = next_edge;
                union(subsets, x, y);
            }
        }

        System.out.println("Following are the edges in the constructed MST:");
        for (i = 0; i < e; ++i)
            System.out.println(result[i].src + " - " + result[i].dest + ": " + result[i].weight);
    }

    public static void main(String[] args) {
        int V = 4, E = 5;
        day48_minimum_spanning_tree_kruskal graph = new day48_minimum_spanning_tree_kruskal(V, E);

        graph.edges[0].src = 0; graph.edges[0].dest = 1; graph.edges[0].weight = 10;
        graph.edges[1].src = 0; graph.edges[1].dest = 2; graph.edges[1].weight = 6;
        graph.edges[2].src = 0; graph.edges[2].dest = 3; graph.edges[2].weight = 5;
        graph.edges[3].src = 1; graph.edges[3].dest = 3; graph.edges[3].weight = 15;
        graph.edges[4].src = 2; graph.edges[4].dest = 3; graph.edges[4].weight = 4;

        graph.KruskalMST();
    }
}

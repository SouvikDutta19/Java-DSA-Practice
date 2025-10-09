import java.util.*;

class Edge implements Comparable<Edge> {
    int src, dest, weight;
    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }
}

public class day103_kruskalsalgorithm {
    int V;
    List<Edge> edges;

    public day103_kruskalsalgorithm(int v) {
        V = v;
        edges = new ArrayList<>();
    }

    public void addEdge(int src, int dest, int weight) {
        Edge edge = new Edge();
        edge.src = src;
        edge.dest = dest;
        edge.weight = weight;
        edges.add(edge);
    }

    int find(int[] parent, int i) {
        if (parent[i] == i) return i;
        return find(parent, parent[i]);
    }

    void union(int[] parent, int[] rank, int x, int y) {
        int xroot = find(parent, x);
        int yroot = find(parent, y);
        if (rank[xroot] < rank[yroot]) parent[xroot] = yroot;
        else if (rank[xroot] > rank[yroot]) parent[yroot] = xroot;
        else {
            parent[yroot] = xroot;
            rank[xroot]++;
        }
    }

    void kruskalMST() {
        Collections.sort(edges);
        int[] parent = new int[V];
        int[] rank = new int[V];
        for (int i = 0; i < V; i++) parent[i] = i;
        List<Edge> result = new ArrayList<>();

        for (Edge edge : edges) {
            int x = find(parent, edge.src);
            int y = find(parent, edge.dest);
            if (x != y) {
                result.add(edge);
                union(parent, rank, x, y);
            }
        }

        System.out.println("Edges in Minimum Spanning Tree:");
        for (Edge e : result)
            System.out.println(e.src + " - " + e.dest + " : " + e.weight);
    }

    public static void main(String[] args) {
        day103_kruskalsalgorithm g = new day103_kruskalsalgorithm(4);
        g.addEdge(0, 1, 10);
        g.addEdge(0, 2, 6);
        g.addEdge(0, 3, 5);
        g.addEdge(1, 3, 15);
        g.addEdge(2, 3, 4);
        g.kruskalMST();
    }
}

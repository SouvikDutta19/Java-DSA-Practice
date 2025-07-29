import java.util.*;

class Edge implements Comparable<Edge> {
    int src, dest, weight;
    public Edge(int s, int d, int w) {
        src = s; dest = d; weight = w;
    }

    public int compareTo(Edge compareEdge) {
        return this.weight - compareEdge.weight;
    }
}

public class MinimumSpanningTree {
    int V;
    List<Edge> edges = new ArrayList<>();

    MinimumSpanningTree(int v) {
        V = v;
    }

    void addEdge(int src, int dest, int weight) {
        edges.add(new Edge(src, dest, weight));
    }

    void kruskalMST() {
        Collections.sort(edges);
        int[] parent = new int[V];
        for (int i = 0; i < V; i++) parent[i] = i;

        int i = 0, e = 0;
        while (e < V - 1 && i < edges.size()) {
            Edge next = edges.get(i++);
            int x = find(parent, next.src);
            int y = find(parent, next.dest);

            if (x != y) {
                System.out.println(next.src + " - " + next.dest + ": " + next.weight);
                union(parent, x, y);
                e++;
            }
        }
    }

    int find(int[] parent, int i) {
        if (parent[i] != i)
            parent[i] = find(parent, parent[i]);
        return parent[i];
    }

    void union(int[] parent, int x, int y) {
        int xroot = find(parent, x);
        int yroot = find(parent, y);
        parent[xroot] = yroot;
    }

    public static void main(String[] args) {
        MinimumSpanningTree g = new MinimumSpanningTree(4);
        g.addEdge(0, 1, 10);
        g.addEdge(0, 2, 6);
        g.addEdge(0, 3, 5);
        g.addEdge(1, 3, 15);
        g.addEdge(2, 3, 4);
        g.kruskalMST();
    }
}

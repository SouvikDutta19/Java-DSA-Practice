import java.util.*;

class Edge implements Comparable<Edge> {
    int src, dest, weight;
    Edge(int s, int d, int w) { src = s; dest = d; weight = w; }
    public int compareTo(Edge e) { return this.weight - e.weight; }
}

public class day127_kruskal_mst {

    int find(int[] parent, int i) {
        if (parent[i] == i) return i;
        return find(parent, parent[i]);
    }

    void union(int[] parent, int[] rank, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);
        if (rank[rootX] < rank[rootY])
            parent[rootX] = rootY;
        else if (rank[rootX] > rank[rootY])
            parent[rootY] = rootX;
        else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }

    void kruskalMST(int V, List<Edge> edges) {
        Collections.sort(edges);
        int[] parent = new int[V];
        int[] rank = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        List<Edge> result = new ArrayList<>();
        int e = 0, i = 0;

        while (e < V - 1 && i < edges.size()) {
            Edge next = edges.get(i++);
            int x = find(parent, next.src);
            int y = find(parent, next.dest);

            if (x != y) {
                result.add(next);
                union(parent, rank, x, y);
                e++;
            }
        }

        System.out.println("Edges in MST:");
        for (Edge edge : result)
            System.out.println(edge.src + " - " + edge.dest + " : " + edge.weight);
    }

    public static void main(String[] args) {
        int V = 4;
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 6));
        edges.add(new Edge(0, 3, 5));
        edges.add(new Edge(1, 3, 15));
        edges.add(new Edge(2, 3, 4));

        new day127_kruskal_mst().kruskalMST(V, edges);
    }
}

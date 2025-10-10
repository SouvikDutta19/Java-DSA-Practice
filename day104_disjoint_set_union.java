import java.util.*;

// Disjoint Set Union (Union-Find) implementation
public class day104_disjoint_set_union {
    static int[] parent, rank;

    static void makeSet(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;
    }

    static int find(int node) {
        if (parent[node] != node)
            parent[node] = find(parent[node]);
        return parent[node];
    }

    static void union(int u, int v) {
        int rootU = find(u), rootV = find(v);
        if (rootU == rootV) return;
        if (rank[rootU] < rank[rootV])
            parent[rootU] = rootV;
        else if (rank[rootU] > rank[rootV])
            parent[rootV] = rootU;
        else {
            parent[rootV] = rootU;
            rank[rootU]++;
        }
    }

    public static void main(String[] args) {
        int n = 5;
        makeSet(n);
        union(0, 2);
        union(4, 2);
        union(3, 1);
        System.out.println(find(4) == find(0));
        System.out.println(find(1) == find(0));
    }
}

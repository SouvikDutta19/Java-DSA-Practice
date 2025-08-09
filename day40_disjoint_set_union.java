import java.util.*;

public class day40_disjoint_set_union {
    static int[] parent, rank;

    static void makeSet(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    static int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    static void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);
        if (xRoot == yRoot) return;

        if (rank[xRoot] < rank[yRoot])
            parent[xRoot] = yRoot;
        else if (rank[xRoot] > rank[yRoot])
            parent[yRoot] = xRoot;
        else {
            parent[yRoot] = xRoot;
            rank[xRoot]++;
        }
    }

    public static void main(String[] args) {
        makeSet(5);
        union(0, 2);
        union(4, 2);
        union(3, 1);

        System.out.println(find(4) == find(0));
        System.out.println(find(1) == find(0));
    }
}

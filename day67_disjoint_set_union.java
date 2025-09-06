import java.util.*;

public class day67_disjoint_set_union {
    static class DSU {
        int[] parent, rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int a, int b) {
            int pa = find(a), pb = find(b);
            if (pa != pb) {
                if (rank[pa] < rank[pb]) parent[pa] = pb;
                else if (rank[pb] < rank[pa]) parent[pb] = pa;
                else { parent[pb] = pa; rank[pa]++; }
            }
        }
    }

    public static void main(String[] args) {
        DSU dsu = new DSU(5);
        dsu.union(0, 1);
        dsu.union(2, 3);
        System.out.println(dsu.find(1) == dsu.find(0));
        System.out.println(dsu.find(4) == dsu.find(2));
    }
}

import java.util.*;

public class day41_disjoint_set_union {
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

        void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px != py) {
                if (rank[px] < rank[py]) parent[px] = py;
                else if (rank[px] > rank[py]) parent[py] = px;
                else {
                    parent[py] = px;
                    rank[px]++;
                }
            }
        }
    }

    public static void main(String[] args) {
        DSU dsu = new DSU(5);
        dsu.union(0, 2);
        dsu.union(4, 2);
        dsu.union(3, 1);

        System.out.println(dsu.find(4) == dsu.find(0));
        System.out.println(dsu.find(1) == dsu.find(0));
    }
}

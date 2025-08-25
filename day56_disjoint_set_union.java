import java.util.*;

public class day56_disjoint_set_union {

    static class DisjointSet {
        int[] parent, rank;

        public DisjointSet(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]); // Path compression
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
            }
        }
    }

    public static void main(String[] args) {
        DisjointSet dsu = new DisjointSet(6);
        dsu.union(0, 1);
        dsu.union(2, 3);
        dsu.union(4, 5);
        dsu.union(1, 2);

        System.out.println("Find(3): " + dsu.find(3));
        System.out.println("Find(5): " + dsu.find(5));
        System.out.println("Find(0): " + dsu.find(0));
    }
}

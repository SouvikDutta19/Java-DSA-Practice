import java.util.*;

public class day99_dsudisjointset {
    int[] parent, rank;

    public day99_dsudisjointset(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
    }

    int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    void union(int x, int y) {
        int rootX = find(x), rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] < rank[rootY]) parent[rootX] = rootY;
            else if (rank[rootX] > rank[rootY]) parent[rootY] = rootX;
            else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }

    public static void main(String[] args) {
        day99_dsudisjointset dsu = new day99_dsudisjointset(5);
        dsu.union(0, 1);
        dsu.union(1, 2);
        System.out.println(dsu.find(2) == dsu.find(0));
        System.out.println(dsu.find(3) == dsu.find(4));
    }
}

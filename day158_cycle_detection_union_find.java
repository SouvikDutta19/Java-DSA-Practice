class UnionFind {
    int parent[];

    UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;
    }

    int find(int i) {
        if (parent[i] != i)
            parent[i] = find(parent[i]);
        return parent[i];
    }

    boolean union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);

        if (xRoot == yRoot)
            return true;

        parent[xRoot] = yRoot;
        return false;
    }
}

public class day158_cycle_detection_union_find {

    public static void main(String[] args) {
        int V = 4;
        int[][] edges = {
                {0, 1},
                {1, 2},
                {2, 3},
                {3, 0} // cycle edge
        };

        UnionFind uf = new UnionFind(V);
        boolean hasCycle = false;

        for (int[] edge : edges) {
            if (uf.union(edge[0], edge[1])) {
                hasCycle = true;
                break;
            }
        }

        System.out.println("Cycle present? " + hasCycle);
    }
}
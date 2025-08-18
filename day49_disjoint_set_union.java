public class day49_disjoint_set_union {
    int[] parent, rank;

    public day49_disjoint_set_union(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
    }

    public int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    public void union(int x, int y) {
        int xr = find(x), yr = find(y);
        if (xr == yr) return;
        if (rank[xr] < rank[yr]) parent[xr] = yr;
        else if (rank[xr] > rank[yr]) parent[yr] = xr;
        else {
            parent[yr] = xr;
            rank[xr]++;
        }
    }

    public static void main(String[] args) {
        day49_disjoint_set_union dsu = new day49_disjoint_set_union(5);
        dsu.union(0, 2);
        dsu.union(4, 2);
        dsu.union(3, 1);

        System.out.println(dsu.find(4) == dsu.find(0)); 
        System.out.println(dsu.find(1) == dsu.find(0)); 
    }
}

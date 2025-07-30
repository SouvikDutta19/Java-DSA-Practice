public class day30_disjointsetunion {
    int[] parent, rank;

    public day30_disjointsetunion(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
    }

    public int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]); // Path compression
        return parent[x];
    }

    public void union(int x, int y) {
        int xr = find(x), yr = find(y);
        if (xr == yr) return;
        if (rank[xr] < rank[yr]) parent[xr] = yr;
        else if (rank[yr] < rank[xr]) parent[yr] = xr;
        else {
            parent[yr] = xr;
            rank[xr]++;
        }
    }

    public static void main(String[] args) {
        day30_disjointsetunion dsu = new day30_disjointsetunion(5);
        dsu.union(0, 2);
        dsu.union(4, 2);
        dsu.union(3, 1);
        System.out.println(dsu.find(4) == dsu.find(0)); // true
        System.out.println(dsu.find(1) == dsu.find(0)); // false
    }
}

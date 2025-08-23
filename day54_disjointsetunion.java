class DisjointSetUnion {
    private int[] parent, rank;

    public DisjointSetUnion(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
    }

    public int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    public void union(int x, int y) {
        int rootX = find(x), rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) parent[rootY] = rootX;
            else if (rank[rootX] < rank[rootY]) parent[rootX] = rootY;
            else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }

    public static void main(String[] args) {
        DisjointSetUnion dsu = new DisjointSetUnion(7);
        dsu.union(0, 1);
        dsu.union(1, 2);
        dsu.union(3, 4);

        System.out.println("Find(2): " + dsu.find(2));
        System.out.println("Find(4): " + dsu.find(4));
        System.out.println("Find(3): " + dsu.find(3));
        dsu.union(2, 4);
        System.out.println("Find(4) after union with 2: " + dsu.find(4));
    }
}

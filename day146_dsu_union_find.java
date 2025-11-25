public class day146_dsu_union_find {

    static class DSU {
        int[] parent, rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            if (x != parent[x])
                parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int a, int b) {
            int pa = find(a);
            int pb = find(b);

            if (pa == pb) return;

            if (rank[pa] < rank[pb]) parent[pa] = pb;
            else if (rank[pb] < rank[pa]) parent[pb] = pa;
            else {
                parent[pb] = pa;
                rank[pa]++;
            }
        }
    }

    public static void main(String[] args) {
        DSU d = new DSU(10);
        d.union(1,2);
        d.union(2,3);

        System.out.println(d.find(3));
        System.out.println(d.find(1));
    }
}

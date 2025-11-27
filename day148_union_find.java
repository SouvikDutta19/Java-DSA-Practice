// Day148 Union-Find (DSU with path compression & union by rank)
public class Day148UnionFind {
    static class DSU {
        int[] parent, rank;
        DSU(int n){
            parent = new int[n];
            rank = new int[n];
            for(int i=0;i<n;i++) parent[i]=i;
        }
        int find(int x){
            if(parent[x]!=x) parent[x] = find(parent[x]);
            return parent[x];
        }
        boolean union(int a, int b){
            int pa = find(a), pb = find(b);
            if(pa==pb) return false;
            if(rank[pa] < rank[pb]) parent[pa]=pb;
            else if(rank[pb] < rank[pa]) parent[pb]=pa;
            else { parent[pb]=pa; rank[pa]++; }
            return true;
        }
    }

    public static void main(String[] args){
        DSU d = new DSU(5);
        d.union(0,1);
        d.union(1,2);
        System.out.println("Find(2) = " + d.find(2));
        System.out.println("Union(3,4) -> " + d.union(3,4));
        System.out.println("Union(2,4) -> " + d.union(2,4));
        System.out.println("Find(4) = " + d.find(4));
    }
}

public class day212_redundant_connection {

    static int[] parent;

    static int find(int x){

        if(parent[x] != x)
            parent[x] = find(parent[x]);

        return parent[x];
    }

    static boolean union(int a, int b){

        int pa = find(a);
        int pb = find(b);

        if(pa == pb)
            return false;

        parent[pa] = pb;
        return true;
    }

    public static int[] findRedundantConnection(int[][] edges){

        int n = edges.length;

        parent = new int[n+1];

        for(int i=0;i<=n;i++)
            parent[i] = i;

        for(int[] e : edges){

            if(!union(e[0], e[1]))
                return e;
        }

        return new int[0];
    }
}
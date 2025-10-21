// day114_dsu_offline_connectivity.java
// Disjoint Set Union (Union-Find) with union by rank & path compression.
// Example: read n, q; then q queries of type "union a b" or "connected a b" -> prints YES/NO.
import java.util.*;
class Main {
    static class DSU {
        int[] p, r;
        DSU(int n){ p=new int[n]; r=new int[n]; for(int i=0;i<n;i++) p[i]=i; }
        int find(int a){ return p[a]==a ? a : (p[a]=find(p[a])); }
        boolean union(int a, int b){
            a=find(a); b=find(b);
            if(a==b) return false;
            if(r[a]<r[b]) p[a]=b;
            else if(r[b]<r[a]) p[b]=a;
            else { p[b]=a; r[a]++; }
            return true;
        }
        boolean same(int a, int b){ return find(a)==find(b); }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        DSU dsu = new DSU(n);
        while(q-- > 0){
            String type = sc.next();
            int a = sc.nextInt(), b = sc.nextInt();
            if(type.equals("union")){
                dsu.union(a,b);
            } else if(type.equals("connected")){
                System.out.println(dsu.same(a,b) ? "YES" : "NO");
            }
        }
        sc.close();
    }
}

import java.io.*;
import java.util.*;

/**
 * Disjoint Set Union (Union-Find) with Rollback.
 * Supports:
 *  - unite(u,v) with history
 *  - snapshot() and rollback(toSnapshot)
 *
 * Demonstrates dynamic connectivity in offline divide & conquer or Mo-on-tree.
 */
public class day67_dsu_rollback {
    static class DSU {
        int n;
        int[] parent, size;
        Deque<int[]> stk = new ArrayDeque<>();
        int comps;

        DSU(int n){
            this.n=n;
            parent=new int[n]; size=new int[n];
            for(int i=0;i<n;i++){parent[i]=i; size[i]=1;}
            comps = n;
        }
        int find(int x){
            while(x!=parent[x]) x=parent[x];
            return x;
        }
        boolean unite(int a,int b){
            a=find(a); b=find(b);
            if(a==b){ stk.push(new int[]{-1,-1,-1}); return false; }
            if(size[a]<size[b]){ int t=a; a=b; b=t; }
            // attach b under a
            stk.push(new int[]{b,parent[b],size[a]});
            parent[b]=a; size[a]+=size[b]; comps--;
            return true;
        }
        int snapshot(){ return stk.size(); }
        void rollback(int snap){
            while(stk.size()>snap){
                int[] rec=stk.pop();
                if(rec[0]==-1) continue;
                int b=rec[0], par=rec[1], sa=rec[2];
                int a=parent[b];
                parent[b]=par;
                size[a]=sa;
                comps++;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken()), m=Integer.parseInt(st.nextToken());
        DSU dsu=new DSU(n);
        int snap = dsu.snapshot();
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken()), v=Integer.parseInt(st.nextToken());
            dsu.unite(u, v);
            System.out.println("components="+dsu.comps);
        }
        dsu.rollback(snap);
        System.out.println("after rollback components="+dsu.comps);
    }
}

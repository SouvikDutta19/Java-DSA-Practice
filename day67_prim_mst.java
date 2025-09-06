import java.io.*;
import java.util.*;

public class day67_prim_mst {
    static class Pair { int v,w; Pair(int v,int w){this.v=v;this.w=w;} }

    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken()), m=Integer.parseInt(st.nextToken());
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken()), v=Integer.parseInt(st.nextToken()), w=Integer.parseInt(st.nextToken());
            adj.get(u).add(new Pair(v,w)); adj.get(v).add(new Pair(u,w));
        }
        boolean[] vis=new boolean[n];
        PriorityQueue<Pair> pq=new PriorityQueue<>(Comparator.comparingInt(a->a.w));
        pq.add(new Pair(0,0));
        int mst=0;
        while(!pq.isEmpty()){
            Pair cur=pq.poll();
            if(vis[cur.v]) continue;
            vis[cur.v]=true;
            mst+=cur.w;
            for(Pair e: adj.get(cur.v)) if(!vis[e.v]) pq.add(e);
        }
        System.out.println(mst);
    }
}

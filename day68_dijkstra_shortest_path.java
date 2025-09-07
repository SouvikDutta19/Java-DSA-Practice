import java.io.*;
import java.util.*;

public class day68_dijkstra_shortest_path {
    static class Pair { int v,w; Pair(int v,int w){this.v=v;this.w=w;} }

    public static void main(String[] args)throws Exception{
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
        int src=0;
        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        PriorityQueue<Pair> pq=new PriorityQueue<>(Comparator.comparingInt(a->a.w));
        pq.add(new Pair(src,0));
        while(!pq.isEmpty()){
            Pair cur=pq.poll();
            if(cur.w>dist[cur.v]) continue;
            for(Pair e:adj.get(cur.v)){
                if(dist[cur.v]+e.w<dist[e.v]){
                    dist[e.v]=dist[cur.v]+e.w;
                    pq.add(new Pair(e.v,dist[e.v]));
                }
            }
        }
        System.out.println(Arrays.toString(dist));
    }
}

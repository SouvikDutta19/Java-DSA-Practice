import java.util.*;

public class day71_prims_mst {
    static class Pair{int v,w;Pair(int v,int w){this.v=v;this.w=w;}}
    public static void main(String[] args){
        int V=5;
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        adj.get(0).add(new Pair(1,2)); adj.get(1).add(new Pair(0,2));
        adj.get(0).add(new Pair(3,6)); adj.get(3).add(new Pair(0,6));
        adj.get(1).add(new Pair(2,3)); adj.get(2).add(new Pair(1,3));
        adj.get(1).add(new Pair(3,8)); adj.get(3).add(new Pair(1,8));
        adj.get(1).add(new Pair(4,5)); adj.get(4).add(new Pair(1,5));
        adj.get(2).add(new Pair(4,7)); adj.get(4).add(new Pair(2,7));

        boolean[] vis=new boolean[V];
        PriorityQueue<Pair> pq=new PriorityQueue<>(Comparator.comparingInt(a->a.w));
        pq.add(new Pair(0,0));
        int cost=0;
        while(!pq.isEmpty()){
            Pair cur=pq.poll();
            if(vis[cur.v]) continue;
            vis[cur.v]=true;
            cost+=cur.w;
            for(Pair e:adj.get(cur.v)) if(!vis[e.v]) pq.add(e);
        }
        System.out.println("MST Cost: "+cost);
    }
}

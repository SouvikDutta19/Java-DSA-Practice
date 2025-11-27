// Day148 Dijkstra's algorithm (min-heap)
import java.util.*;
public class Day148Dijkstra {
    static class Edge {int to; int w; Edge(int t,int w){to=t;this.w=w;}}

    public static int[] dijkstra(List<List<Edge>> graph, int src){
        int n = graph.size();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src]=0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[1]));
        pq.add(new int[]{src,0});
        boolean[] seen = new boolean[n];

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int u = cur[0], d = cur[1];
            if(seen[u]) continue;
            seen[u]=true;
            for(Edge e: graph.get(u)){
                if(dist[e.to] > d + e.w){
                    dist[e.to] = d + e.w;
                    pq.add(new int[]{e.to, dist[e.to]});
                }
            }
        }
        return dist;
    }

    public static void main(String[] args){
        int n = 6;
        List<List<Edge>> g = new ArrayList<>();
        for(int i=0;i<n;i++) g.add(new ArrayList<>());

        // add edges (undirected example)
        g.get(0).add(new Edge(1,7));
        g.get(0).add(new Edge(2,9));
        g.get(0).add(new Edge(5,14));
        g.get(1).add(new Edge(2,10));
        g.get(1).add(new Edge(3,15));
        g.get(2).add(new Edge(3,11));
        g.get(2).add(new Edge(5,2));
        g.get(3).add(new Edge(4,6));
        g.get(4).add(new Edge(5,9));

        int[] dist = dijkstra(g, 0);
        System.out.println("Shortest distances from node 0:");
        for(int i=0;i<dist.length;i++) System.out.println(i + ": " + dist[i]);
    }
}

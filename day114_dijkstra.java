// day114_dijkstra.java
// Single-source shortest paths on weighted directed graph using Dijkstra (priority queue).
import java.util.*;
class Main {
    static class Edge { int to; int w; Edge(int t, int w){this.to=t;this.w=w;} }
    public static long[] dijkstra(int n, List<List<Edge>> g, int src) {
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE/4);
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        dist[src]=0;
        pq.add(new long[]{0, src});
        while(!pq.isEmpty()){
            long[] cur = pq.poll();
            long d = cur[0]; int u = (int)cur[1];
            if(d>dist[u]) continue;
            for(Edge e: g.get(u)){
                if(dist[e.to] > d + e.w){
                    dist[e.to] = d + e.w;
                    pq.add(new long[]{dist[e.to], e.to});
                }
            }
        }
        return dist;
    }

    // example usage / simple IO
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        // Input: n m src
        int n = sc.nextInt();
        int m = sc.nextInt();
        int src = sc.nextInt();
        List<List<Edge>> g = new ArrayList<>();
        for(int i=0;i<n;i++) g.add(new ArrayList<>());
        for(int i=0;i<m;i++){
            int u = sc.nextInt(), v = sc.nextInt(), w = sc.nextInt();
            g.get(u).add(new Edge(v,w)); // directed
        }
        long[] dist = dijkstra(n, g, src);
        for(int i=0;i<n;i++){
            if(dist[i]>=Long.MAX_VALUE/8) System.out.println("INF");
            else System.out.println(dist[i]);
        }
        sc.close();
    }
}

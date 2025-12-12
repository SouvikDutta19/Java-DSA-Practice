// Day162 - Dijkstra (adjacency list, min-heap)
import java.util.*;

public class day162_dijkstra_adjlist {
    static class Edge { int to, w; Edge(int t,int w){to=t;this.w=w;} }

    public static int[] dijkstra(List<List<Edge>> g, int src) {
        int n = g.size();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[1]));
        pq.offer(new int[]{src,0});
        boolean[] seen = new boolean[n];

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0], d = cur[1];
            if (seen[u]) continue;
            seen[u] = true;
            for (Edge e : g.get(u)) {
                if (dist[e.to] > d + e.w) {
                    dist[e.to] = d + e.w;
                    pq.offer(new int[]{e.to, dist[e.to]});
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int n = 5;
        List<List<Edge>> g = new ArrayList<>();
        for (int i=0;i<n;i++) g.add(new ArrayList<>());
        g.get(0).add(new Edge(1,10)); g.get(0).add(new Edge(4,5));
        g.get(1).add(new Edge(2,1));  g.get(1).add(new Edge(4,2));
        g.get(2).add(new Edge(3,4));
        g.get(3).add(new Edge(2,6));  g.get(3).add(new Edge(0,7));
        g.get(4).add(new Edge(1,3));  g.get(4).add(new Edge(2,9)); g.get(4).add(new Edge(3,2));

        int[] dist = dijkstra(g,0);
        System.out.println("Distances from 0:");
        for (int i=0;i<n;i++) System.out.println(i + " -> " + dist[i]);
    }
}
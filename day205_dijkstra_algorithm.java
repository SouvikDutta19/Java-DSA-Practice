import java.util.*;

public class day205_dijkstra_algorithm {

    public static int[] dijkstra(int V, List<List<int[]>> adj, int src){

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{src,0});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int node = curr[0];
            int d = curr[1];

            if(d > dist[node]) continue;

            for(int[] nei : adj.get(node)){
                int v = nei[0], wt = nei[1];

                if(dist[node] + wt < dist[v]){
                    dist[v] = dist[node] + wt;
                    pq.add(new int[]{v, dist[v]});
                }
            }
        }
        return dist;
    }
}
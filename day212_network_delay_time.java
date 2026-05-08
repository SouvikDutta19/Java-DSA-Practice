import java.util.*;

public class day212_network_delay_time {

    public static int networkDelayTime(int[][] times, int n, int k){

        List<List<int[]>> graph = new ArrayList<>();

        for(int i=0;i<=n;i++)
            graph.add(new ArrayList<>());

        for(int[] t : times){
            graph.get(t[0]).add(new int[]{t[1], t[2]});
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a,b) -> a[1]-b[1]);

        dist[k] = 0;
        pq.add(new int[]{k,0});

        while(!pq.isEmpty()){

            int[] curr = pq.poll();
            int node = curr[0];
            int time = curr[1];

            if(time > dist[node]) continue;

            for(int[] nei : graph.get(node)){

                int v = nei[0];
                int wt = nei[1];

                if(dist[node] + wt < dist[v]){
                    dist[v] = dist[node] + wt;
                    pq.add(new int[]{v, dist[v]});
                }
            }
        }

        int max = 0;

        for(int i=1;i<=n;i++){
            if(dist[i] == Integer.MAX_VALUE)
                return -1;

            max = Math.max(max, dist[i]);
        }

        return max;
    }
}
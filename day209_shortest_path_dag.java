import java.util.*;

public class day209_shortest_path_dag {

    static void topo(int node, boolean[] vis, Stack<Integer> st, List<List<int[]>> adj){
        vis[node] = true;
        for(int[] nei : adj.get(node))
            if(!vis[nei[0]]) topo(nei[0], vis, st, adj);
        st.push(node);
    }

    public static int[] shortestPath(int V, List<List<int[]>> adj, int src){

        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<V;i++)
            if(!vis[i]) topo(i, vis, st, adj);

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        while(!st.isEmpty()){
            int node = st.pop();

            if(dist[node] != Integer.MAX_VALUE){
                for(int[] nei : adj.get(node)){
                    int v = nei[0], wt = nei[1];
                    if(dist[node] + wt < dist[v])
                        dist[v] = dist[node] + wt;
                }
            }
        }
        return dist;
    }
}
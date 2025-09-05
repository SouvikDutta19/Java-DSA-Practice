import java.io.*;
import java.util.*;

/**
 * Min-Cost Max-Flow with potentials (successive shortest augmenting paths).
 * Complexity: O(F * m log n) with Dijkstra + potentials (non-negative reduced costs).
 *
 * Input:
 * n m s t
 * m lines: u v cap cost
 * Output:
 * maxFlow minCost
 */
public class day67_min_cost_max_flow {
    static class Edge {
        int to, rev, cap;
        long cost;
        Edge(int to, int rev, int cap, long cost){ this.to=to; this.rev=rev; this.cap=cap; this.cost=cost; }
    }
    static List<Edge>[] g;
    static void addEdge(int u,int v,int cap,long cost){
        g[u].add(new Edge(v, g[v].size(), cap, cost));
        g[v].add(new Edge(u, g[u].size()-1, 0, -cost));
    }

    static long[] dist, pot;
    static Edge[] parentEdge;
    static int[] parentNode;

    static long[] minCostMaxFlow(int s,int t){
        int n=g.length;
        long flow=0, cost=0;
        pot = new long[n];
        dist = new long[n];
        parentEdge = new Edge[n];
        parentNode = new int[n];

        while(true){
            Arrays.fill(dist, Long.MAX_VALUE/4);
            dist[s]=0;
            PriorityQueue<int[]> pq=new PriorityQueue<>(Comparator.comparingLong(a->a[1]));
            pq.add(new int[]{s,0});
            while(!pq.isEmpty()){
                int u=pq.poll()[0];
                for(int i=0;i<g[u].size();i++){
                    Edge e=g[u].get(i);
                    if(e.cap<=0) continue;
                    long nd = dist[u] + e.cost + pot[u] - pot[e.to];
                    if(nd < dist[e.to]){
                        dist[e.to]=nd;
                        parentEdge[e.to]=e;
                        parentNode[e.to]=u;
                        pq.add(new int[]{e.to,(int)nd});
                    }
                }
            }
            if(dist[t] == Long.MAX_VALUE/4) break;
            for(int i=0;i<n;i++) if(dist[i]<Long.MAX_VALUE/4) pot[i]+=dist[i];

            int push=Integer.MAX_VALUE;
            for(int v=t; v!=s; v=parentNode[v]) push=Math.min(push, parentEdge[v].cap);
            for(int v=t; v!=s; v=parentNode[v]){
                Edge e=parentEdge[v];
                e.cap-=push;
                g[v].get(e.rev).cap+=push;
                cost += (long)push * e.cost;
            }
            flow += push;
        }
        return new long[]{flow,cost};
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken()), m=Integer.parseInt(st.nextToken());
        int s=Integer.parseInt(st.nextToken()), t=Integer.parseInt(st.nextToken());
        g=new ArrayList[n];
        for(int i=0;i<n;i++) g[i]=new ArrayList<>();
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken()), v=Integer.parseInt(st.nextToken()), cap=Integer.parseInt(st.nextToken());
            long cost=Long.parseLong(st.nextToken());
            addEdge(u,v,cap,cost);
        }
        long[] res=minCostMaxFlow(s,t);
        System.out.println(res[0]+" "+res[1]);
    }
}

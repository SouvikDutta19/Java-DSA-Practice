import java.io.*;
import java.util.*;

public class day67_bellman_ford {
    static class Edge {
        int u,v,w;
        Edge(int u,int v,int w){this.u=u;this.v=v;this.w=w;}
    }

    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken()), m=Integer.parseInt(st.nextToken());
        List<Edge> edges=new ArrayList<>();
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            edges.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        int src=0;
        int[] dist=new int[n];
        Arrays.fill(dist,100000000);
        dist[src]=0;
        for(int i=1;i<n;i++){
            for(Edge e:edges) if(dist[e.u]+e.w<dist[e.v]) dist[e.v]=dist[e.u]+e.w;
        }
        for(Edge e:edges){
            if(dist[e.u]+e.w<dist[e.v]){
                System.out.println("Negative cycle detected");
                return;
            }
        }
        System.out.println(Arrays.toString(dist));
    }
}

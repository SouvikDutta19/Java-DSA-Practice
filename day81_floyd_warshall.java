import java.util.*;

public class day81_floyd_warshall {
    final static int INF=99999;
    public static void floydWarshall(int[][] graph,int V) {
        int[][] dist=new int[V][V];
        for(int i=0;i<V;i++) System.arraycopy(graph[i],0,dist[i],0,V);
        for(int k=0;k<V;k++)
            for(int i=0;i<V;i++)
                for(int j=0;j<V;j++)
                    if(dist[i][k]+dist[k][j]<dist[i][j])
                        dist[i][j]=dist[i][k]+dist[k][j];

        for(int i=0;i<V;i++) System.out.println(Arrays.toString(dist[i]));
    }

    public static void main(String[] args) {
        int[][] graph={{0,5,INF,10},{INF,0,3,INF},{INF,INF,0,1},{INF,INF,INF,0}};
        floydWarshall(graph,4);
    }
}

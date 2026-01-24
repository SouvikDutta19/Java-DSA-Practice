import java.util.*;

public class day182_floyd_warshall {

    static final int INF = 99999;

    public static void floyd(int[][] graph, int V) {
        int[][] dist = new int[V][V];

        for (int i = 0; i < V; i++)
            dist[i] = graph[i].clone();

        for (int k = 0; k < V; k++)
            for (int i = 0; i < V; i++)
                for (int j = 0; j < V; j++)
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++)
                System.out.print(dist[i][j] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0,3,INF,5},
            {2,0,INF,4},
            {INF,1,0,INF},
            {INF,INF,2,0}
        };
        floyd(graph, 4);
    }
}
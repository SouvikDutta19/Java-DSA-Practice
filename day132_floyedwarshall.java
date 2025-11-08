// day132_floyedwarshall.java
import java.util.*;

public class day132_floyedwarshall {
    final static int INF = 99999;

    void floydWarshall(int[][] graph, int V) {
        int[][] dist = new int[V][V];
        for (int i = 0; i < V; i++)
            System.arraycopy(graph[i], 0, dist[i], 0, V);

        for (int k = 0; k < V; k++)
            for (int i = 0; i < V; i++)
                for (int j = 0; j < V; j++)
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];

        System.out.println("Shortest distance matrix:");
        for (int[] row : dist) {
            for (int val : row)
                System.out.print((val == INF ? "INF" : val) + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 5, INF, 10},
            {INF, 0, 3, INF},
            {INF, INF, 0, 1},
            {INF, INF, INF, 0}
        };
        new day132_floyedwarshall().floydWarshall(graph, 4);
    }
}

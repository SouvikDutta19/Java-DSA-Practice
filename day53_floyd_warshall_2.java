import java.util.*;

public class day53_floyd_warshall_2 {
    public static final int INF = 99999;

    public static void floydWarshall(int[][] graph, int V) {
        int[][] dist = new int[V][V];
        for (int i = 0; i < V; ++i)
            System.arraycopy(graph[i], 0, dist[i], 0, V);

        for (int k = 0; k < V; ++k) {
            for (int i = 0; i < V; ++i) {
                for (int j = 0; j < V; ++j) {
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }

        System.out.println("All Pairs Shortest Path:");
        for (int i = 0; i < V; ++i) {
            for (int j = 0; j < V; ++j) {
                if (dist[i][j] == INF) System.out.print("INF ");
                else System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int V = 4;
        int[][] graph = {
            {0, 5, INF, 10},
            {INF, 0, 3, INF},
            {INF, INF, 0, 1},
            {INF, INF, INF, 0}
        };

        floydWarshall(graph, V);
    }
}

import java.util.*;

public class day53_floyd_warshall {
    public static void floydWarshall(int[][] graph, int V) {
        int[][] dist = new int[V][V];
        for (int i = 0; i < V; i++)
            dist[i] = Arrays.copyOf(graph[i], V);

        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE &&
                            dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        System.out.println("All-Pairs Shortest Paths:");
        for (int i = 0; i < V; i++)
            System.out.println(Arrays.toString(dist[i]));
    }

    public static void main(String[] args) {
        int INF = Integer.MAX_VALUE;
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

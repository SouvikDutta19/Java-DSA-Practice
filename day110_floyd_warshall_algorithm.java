import java.util.*;

public class day110_floyd_warshall_algorithm {

    final static int INF = 99999;

    void floydWarshall(int[][] graph) {
        int V = graph.length;
        int[][] dist = new int[V][V];

        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++)
                dist[i][j] = graph[i][j];

        for (int k = 0; k < V; k++)
            for (int i = 0; i < V; i++)
                for (int j = 0; j < V; j++)
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];

        printSolution(dist);
    }

    void printSolution(int[][] dist) {
        System.out.println("Shortest distances between every pair of vertices:");
        for (int[] row : dist) {
            for (int d : row)
                System.out.print((d == INF ? "INF" : d) + " ");
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

        new day110_floyd_warshall_algorithm().floydWarshall(graph);
    }
}

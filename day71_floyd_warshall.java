import java.util.*;

public class day71_floyd_warshall {
    static final int INF = 1000000;

    public static void main(String[] args) {
        int[][] graph = {
            {0, 5, INF, 10},
            {INF, 0, 3, INF},
            {INF, INF, 0, 1},
            {INF, INF, INF, 0}
        };

        int V = graph.length;
        int[][] dist = new int[V][V];
        for (int i = 0; i < V; i++) dist[i] = Arrays.copyOf(graph[i], V);

        for (int k = 0; k < V; k++)
            for (int i = 0; i < V; i++)
                for (int j = 0; j < V; j++)
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];

        for (int[] row : dist) System.out.println(Arrays.toString(row));
    }
}

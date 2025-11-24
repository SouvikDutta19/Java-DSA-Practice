public class day145_floyd_warshall {

    static final int INF = 99999;

    static void floyd(int[][] graph) {
        int n = graph.length;
        int[][] dist = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                dist[i][j] = graph[i][j];

        for (int k = 0; k < n; k++)
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];

        for (int[] row : dist) {
            for (int val : row) System.out.print(val + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 3, INF, 5},
            {2, 0, INF, 4},
            {INF, 1, 0, INF},
            {INF, INF, 2, 0}
        };
        floyd(graph);
    }
}

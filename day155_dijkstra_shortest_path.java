import java.util.*;

public class day155_dijkstra_shortest_path {

    static final int INF = Integer.MAX_VALUE;

    int minDistance(int dist[], boolean visited[]) {
        int min = INF, minIndex = -1;

        for (int i = 0; i < dist.length; i++) {
            if (!visited[i] && dist[i] <= min) {
                min = dist[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    void dijkstra(int graph[][], int src) {
        int V = graph.length;
        int dist[] = new int[V];
        boolean visited[] = new boolean[V];

        Arrays.fill(dist, INF);
        dist[src] = 0;

        for (int count = 0; count < V - 1; count++) {
            int u = minDistance(dist, visited);
            visited[u] = true;

            for (int v = 0; v < V; v++) {
                if (!visited[v] && graph[u][v] != 0 &&
                        dist[u] != INF &&
                        dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        System.out.println("Vertex   Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i + " \t\t " + dist[i]);
    }

    public static void main(String[] args) {
        int graph[][] = {
                {0, 4, 0, 0, 0, 0},
                {4, 0, 8, 0, 0, 0},
                {0, 8, 0, 7, 0, 4},
                {0, 0, 7, 0, 9, 14},
                {0, 0, 0, 9, 0, 10},
                {0, 0, 4, 14, 10, 0}
        };

        day155_dijkstra_shortest_path d = new day155_dijkstra_shortest_path();
        d.dijkstra(graph, 0);
    }
}
// day121_shortestpathindag.java
import java.util.*;

public class day121_shortestpathindag {
    static class Edge {
        int v, weight;
        Edge(int v, int w) { this.v = v; this.weight = w; }
    }

    public static void shortestPath(int n, List<List<Edge>> adj, int src) {
        Stack<Integer> topo = new Stack<>();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++)
            if (!visited[i]) topologicalSort(i, visited, adj, topo);

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        while (!topo.isEmpty()) {
            int u = topo.pop();
            if (dist[u] != Integer.MAX_VALUE) {
                for (Edge e : adj.get(u))
                    if (dist[u] + e.weight < dist[e.v])
                        dist[e.v] = dist[u] + e.weight;
            }
        }

        System.out.println("Shortest distances from source " + src + ":");
        for (int d : dist) System.out.print((d == Integer.MAX_VALUE ? "INF" : d) + " ");
    }

    private static void topologicalSort(int v, boolean[] visited, List<List<Edge>> adj, Stack<Integer> stack) {
        visited[v] = true;
        for (Edge e : adj.get(v))
            if (!visited[e.v])
                topologicalSort(e.v, visited, adj, stack);
        stack.push(v);
    }

    public static void main(String[] args) {
        int n = 6;
        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        adj.get(0).add(new Edge(1, 5));
        adj.get(0).add(new Edge(2, 3));
        adj.get(1).add(new Edge(3, 6));
        adj.get(1).add(new Edge(2, 2));
        adj.get(2).add(new Edge(4, 4));
        adj.get(2).add(new Edge(5, 2));
        adj.get(2).add(new Edge(3, 7));
        adj.get(3).add(new Edge(4, -1));
        adj.get(4).add(new Edge(5, -2));

        shortestPath(n, adj, 1);
    }
}

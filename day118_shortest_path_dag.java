import java.util.*;

public class day118_shortest_path_dag {
    static class Edge {
        int v, weight;
        Edge(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }
    }

    void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> stack, List<List<Edge>> adj) {
        visited[v] = true;
        for (Edge e : adj.get(v)) {
            if (!visited[e.v])
                topologicalSortUtil(e.v, visited, stack, adj);
        }
        stack.push(v);
    }

    void shortestPath(int s, List<List<Edge>> adj, int V) {
        Stack<Integer> stack = new Stack<>();
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++)
            if (!visited[i])
                topologicalSortUtil(i, visited, stack, adj);

        dist[s] = 0;

        while (!stack.isEmpty()) {
            int u = stack.pop();
            if (dist[u] != Integer.MAX_VALUE) {
                for (Edge e : adj.get(u)) {
                    if (dist[e.v] > dist[u] + e.weight)
                        dist[e.v] = dist[u] + e.weight;
                }
            }
        }

        System.out.println("Shortest distances from source " + s + ":");
        for (int i = 0; i < V; i++)
            System.out.println(i + " -> " + (dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]));
    }

    public static void main(String[] args) {
        int V = 6;
        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        adj.get(0).add(new Edge(1, 5));
        adj.get(0).add(new Edge(2, 3));
        adj.get(1).add(new Edge(3, 6));
        adj.get(1).add(new Edge(2, 2));
        adj.get(2).add(new Edge(4, 4));
        adj.get(2).add(new Edge(5, 2));
        adj.get(2).add(new Edge(3, 7));
        adj.get(3).add(new Edge(4, -1));
        adj.get(4).add(new Edge(5, -2));

        new day118_shortest_path_dag().shortestPath(1, adj, V);
    }
}

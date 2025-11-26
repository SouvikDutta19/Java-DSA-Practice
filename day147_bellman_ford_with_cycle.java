import java.util.*;

public class day147_bellman_ford_with_cycle {

    static class Edge {
        int u, v, w;
        Edge(int u, int v, int w) { this.u = u; this.v = v; this.w = w; }
    }

    // Returns distance array (or null if negative cycle reachable from src).
    // Also fills parent[] for path reconstruction.
    public static int[] bellmanFord(List<Edge> edges, int n, int src, int[] parent) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        dist[src] = 0;

        for (int i = 1; i <= n - 1; i++) {
            boolean changed = false;
            for (Edge e : edges) {
                if (dist[e.u] != Integer.MAX_VALUE && dist[e.u] + e.w < dist[e.v]) {
                    dist[e.v] = dist[e.u] + e.w;
                    parent[e.v] = e.u;
                    changed = true;
                }
            }
            if (!changed) break;
        }

        // check for negative-weight cycles
        for (Edge e : edges) {
            if (dist[e.u] != Integer.MAX_VALUE && dist[e.u] + e.w < dist[e.v]) {
                return null; // negative cycle detected
            }
        }

        return dist;
    }

    public static List<Integer> reconstructPath(int[] parent, int src, int target) {
        LinkedList<Integer> path = new LinkedList<>();
        if (parent[target] == -1 && src != target) return path;
        int cur = target;
        path.addFirst(cur);
        while (cur != src) {
            cur = parent[cur];
            if (cur == -1) return new ArrayList<>();
            path.addFirst(cur);
        }
        return path;
    }

    public static void main(String[] args) {
        int n = 5;
        List<Edge> edges = new ArrayList<>();
        // directed edges with possible negative weights
        edges.add(new Edge(0,1,6));
        edges.add(new Edge(0,2,7));
        edges.add(new Edge(1,2,8));
        edges.add(new Edge(1,3,5));
        edges.add(new Edge(1,4,-4));
        edges.add(new Edge(2,3,-3));
        edges.add(new Edge(2,4,9));
        edges.add(new Edge(3,1,-2));
        edges.add(new Edge(4,3,7));
        edges.add(new Edge(4,0,2));

        int src = 0;
        int[] parent = new int[n];
        int[] dist = bellmanFord(edges, n, src, parent);

        if (dist == null) {
            System.out.println("Graph contains a negative weight cycle reachable from source.");
        } else {
            System.out.println("Distances from " + src + ": " + Arrays.toString(dist));
            System.out.println("Parent array: " + Arrays.toString(parent));
            System.out.println("Path to 3: " + reconstructPath(parent, src, 3));
        }
    }
}

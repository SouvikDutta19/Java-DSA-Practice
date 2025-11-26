import java.util.*;

public class day147_dijkstra_with_path {

    static class Edge {
        int to, w;
        Edge(int to, int w) { this.to = to; this.w = w; }
    }

    public static int[] dijkstra(List<List<Edge>> graph, int src, int[] parent) {
        int n = graph.size();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1])); // {node,dist}
        dist[src] = 0;
        pq.offer(new int[]{src, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0], d = cur[1];
            if (d != dist[u]) continue;

            for (Edge e : graph.get(u)) {
                int v = e.to, w = e.w;
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    parent[v] = u;
                    pq.offer(new int[]{v, dist[v]});
                }
            }
        }
        return dist;
    }

    // Reconstruct path from src to target using parent array
    public static List<Integer> buildPath(int[] parent, int src, int target) {
        LinkedList<Integer> path = new LinkedList<>();
        if (parent[target] == -1 && src != target) {
            // If target unreachable (and not the src itself)
            return path;
        }
        int cur = target;
        path.addFirst(cur);
        while (cur != src) {
            cur = parent[cur];
            if (cur == -1) return new ArrayList<>(); // unreachable
            path.addFirst(cur);
        }
        return path;
    }

    public static void main(String[] args) {
        int n = 6;
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        // add undirected weighted edges (you can convert to directed if needed)
        graph.get(0).add(new Edge(1, 7));
        graph.get(0).add(new Edge(2, 9));
        graph.get(0).add(new Edge(5, 14));
        graph.get(1).add(new Edge(2, 10));
        graph.get(1).add(new Edge(3, 15));
        graph.get(2).add(new Edge(3, 11));
        graph.get(2).add(new Edge(5, 2));
        graph.get(3).add(new Edge(4, 6));
        graph.get(4).add(new Edge(5, 9));

        // for undirected, add reverse edges
        graph.get(1).add(new Edge(0,7));
        graph.get(2).add(new Edge(0,9));
        graph.get(5).add(new Edge(0,14));
        graph.get(2).add(new Edge(1,10));
        graph.get(3).add(new Edge(1,15));
        graph.get(3).add(new Edge(2,11));
        graph.get(5).add(new Edge(2,2));
        graph.get(4).add(new Edge(3,6));
        graph.get(5).add(new Edge(4,9));

        int src = 0;
        int[] parent = new int[n];
        int[] dist = dijkstra(graph, src, parent);

        System.out.println("Distances from node " + src + ": " + Arrays.toString(dist));
        int target = 4;
        List<Integer> path = buildPath(parent, src, target);
        System.out.println("Path from " + src + " to " + target + ": " + path);
    }
}

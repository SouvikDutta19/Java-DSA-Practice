import java.util.*;

class WeightedGraphDijkstra {
    static class Edge {
        int dest, weight;
        Edge(int d, int w) {
            dest = d; weight = w;
        }
    }
    
    static class Pair implements Comparable<Pair> {
        int vertex, distance;
        Pair(int v, int d) {
            vertex = v; distance = d;
        }
        public int compareTo(Pair other) {
            return this.distance - other.distance;
        }
    }

    public static void dijkstra(List<List<Edge>> graph, int src) {
        int V = graph.size();
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int u = current.vertex;
            for (Edge edge : graph.get(u)) {
                int v = edge.dest;
                int newDist = dist[u] + edge.weight;
                if (newDist < dist[v]) {
                    dist[v] = newDist;
                    pq.add(new Pair(v, newDist));
                }
            }
        }

        System.out.println("Vertex   Distance from Source");
        for (int i = 0; i < V; i++) {
            System.out.println(i + " \t\t " + dist[i]);
        }
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());

        graph.get(0).add(new Edge(1, 9));
        graph.get(0).add(new Edge(2, 6));
        graph.get(0).add(new Edge(3, 5));
        graph.get(0).add(new Edge(4, 3));
        graph.get(2).add(new Edge(1, 2));
        graph.get(2).add(new Edge(3, 4));

        dijkstra(graph, 0);
    }
}

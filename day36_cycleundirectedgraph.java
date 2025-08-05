import java.util.*;

public class day36_cycleundirectedgraph {
    static class Graph {
        int V;
        ArrayList<ArrayList<Integer>> adj;

        Graph(int V) {
            this.V = V;
            adj = new ArrayList<>();
            for (int i = 0; i < V; i++)
                adj.add(new ArrayList<>());
        }

        void addEdge(int u, int v) {
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean isCyclic() {
            boolean[] visited = new boolean[V];
            for (int i = 0; i < V; i++) {
                if (!visited[i] && bfsCycleCheck(i, visited)) return true;
            }
            return false;
        }

        boolean bfsCycleCheck(int src, boolean[] visited) {
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{src, -1});
            visited[src] = true;

            while (!q.isEmpty()) {
                int[] pair = q.poll();
                int node = pair[0], parent = pair[1];

                for (int neighbor : adj.get(node)) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        q.add(new int[]{neighbor, node});
                    } else if (neighbor != parent)
                        return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 0);  // cycle
        g.addEdge(3, 4);  // disconnected component

        System.out.println("Graph contains cycle: " + g.isCyclic());
    }
}

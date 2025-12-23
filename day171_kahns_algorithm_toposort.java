import java.util.*;

public class day171_kahns_algorithm_toposort {

    public static void topologicalSort(int V, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[V];

        for (int i = 0; i < V; i++)
            graph.add(new ArrayList<>());

        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            indegree[e[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++)
            if (indegree[i] == 0)
                queue.add(i);

        List<Integer> topo = new ArrayList<>();

        while (!queue.isEmpty()) {
            int node = queue.poll();
            topo.add(node);

            for (int neigh : graph.get(node)) {
                indegree[neigh]--;
                if (indegree[neigh] == 0)
                    queue.add(neigh);
            }
        }

        if (topo.size() != V)
            System.out.println("Cycle detected");
        else
            System.out.println("Topological Order: " + topo);
    }

    public static void main(String[] args) {
        int V = 6;
        int[][] edges = {
                {5, 2}, {5, 0}, {4, 0},
                {4, 1}, {2, 3}, {3, 1}
        };
        topologicalSort(V, edges);
    }
}
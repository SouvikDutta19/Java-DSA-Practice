import java.util.*;

public class day217_graph_valid_tree {

    public static boolean validTree(
            int n,
            int[][] edges) {

        if (edges.length != n - 1)
            return false;

        List<List<Integer>> graph =
                new ArrayList<>();

        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for (int[] edge : edges) {

            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited =
                new boolean[n];

        Queue<Integer> queue =
                new LinkedList<>();

        queue.offer(0);
        visited[0] = true;

        int count = 0;

        while (!queue.isEmpty()) {

            int node = queue.poll();
            count++;

            for (int next : graph.get(node)) {

                if (!visited[next]) {

                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }

        return count == n;
    }
}
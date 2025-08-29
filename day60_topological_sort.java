import java.util.*;

public class day60_topological_sort {
    public static List<Integer> topologicalSort(int n, List<int[]> edges) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) if (indegree[i] == 0) queue.add(i);

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);
            for (int nei : graph.get(node)) {
                indegree[nei]--;
                if (indegree[nei] == 0) queue.add(nei);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<int[]> edges = Arrays.asList(new int[]{5,2}, new int[]{5,0}, new int[]{4,0}, new int[]{4,1}, new int[]{2,3}, new int[]{3,1});
        System.out.println("Topological Sort Order: " + topologicalSort(6, edges));
    }
}

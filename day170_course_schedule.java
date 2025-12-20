import java.util.*;

public class day170_course_schedule {

    static boolean dfs(int node, List<List<Integer>> graph,
                       boolean[] visited, boolean[] recStack) {

        visited[node] = true;
        recStack[node] = true;

        for (int nei : graph.get(node)) {
            if (!visited[nei] && dfs(nei, graph, visited, recStack))
                return true;
            else if (recStack[nei])
                return true;
        }
        recStack[node] = false;
        return false;
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            graph.add(new ArrayList<>());

        for (int[] p : prerequisites)
            graph.get(p[1]).add(p[0]);

        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++)
            if (!visited[i] && dfs(i, graph, visited, recStack))
                return false;

        return true;
    }

    public static void main(String[] args) {
        int[][] pre = {{1,0},{0,1}};
        System.out.println("Can finish courses: " + canFinish(2, pre));
    }
}
// Program to check if all courses can be completed using Topological Sort (Cycle detection in Directed Graph)

import java.util.*;

public class day113_course_schedule_topological_sort {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            graph.add(new ArrayList<>());

        int[] indegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++)
            if (indegree[i] == 0) queue.add(i);

        int count = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            for (int next : graph.get(course)) {
                indegree[next]--;
                if (indegree[next] == 0) queue.add(next);
            }
        }

        return count == numCourses;
    }

    public static void main(String[] args) {
        int[][] pre = {{1,0}, {2,1}, {3,2}};
        System.out.println("Can finish all courses: " + canFinish(4, pre));
    }
}

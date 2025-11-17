// day139_course_schedule.java

import java.util.*;

public class day139_course_schedule {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());

        for (int[] p : prerequisites) {
            graph.get(p[1]).add(p[0]);
            indegree[p[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++)
            if (indegree[i] == 0) queue.offer(i);

        int visited = 0;

        while (!queue.isEmpty()) {
            int course = queue.poll();
            visited++;

            for (int next : graph.get(course)) {
                indegree[next]--;
                if (indegree[next] == 0) queue.offer(next);
            }
        }

        return visited == numCourses;
    }

    public static void main(String[] args) {
        int[][] prereq = {{1, 0}, {2, 1}, {3, 2}};
        System.out.println(canFinish(4, prereq));
    }
}

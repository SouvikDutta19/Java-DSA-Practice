// day137_course_schedule.java
import java.util.*;

public class day137_course_schedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());
        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++)
            if (indegree[i] == 0)
                queue.add(i);

        int completed = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            completed++;
            for (int next : graph.get(course)) {
                indegree[next]--;
                if (indegree[next] == 0)
                    queue.add(next);
            }
        }
        return completed == numCourses;
    }

    public static void main(String[] args) {
        int[][] prerequisites = {{1,0}, {2,1}};
        System.out.println("Can finish all courses: " + canFinish(3, prerequisites));
    }
}

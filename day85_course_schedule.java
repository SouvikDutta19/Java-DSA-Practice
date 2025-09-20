import java.util.*;

public class day85_course_schedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());
        int[] indegree = new int[numCourses];

        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) if (indegree[i] == 0) q.add(i);

        int count = 0;
        while (!q.isEmpty()) {
            int course = q.poll();
            count++;
            for (int next : graph.get(course)) {
                indegree[next]--;
                if (indegree[next] == 0) q.add(next);
            }
        }
        return count == numCourses;
    }

    public static void main(String[] args) {
        int[][] prereq = {{1,0},{2,1},{3,2}};
        System.out.println("Can Finish Courses: " + canFinish(4, prereq));
    }
}

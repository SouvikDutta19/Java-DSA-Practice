import java.util.*;

public class CourseScheduleChecker {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
            inDegree[pre[0]]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0)
                queue.offer(i);
        }
        
        int count = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            for (int next : graph.get(course)) {
                if (--inDegree[next] == 0)
                    queue.offer(next);
            }
        }
        
        return count == numCourses;
    }

    public static void main(String[] args) {
        CourseScheduleChecker checker = new CourseScheduleChecker();
        int[][] prerequisites = {{1, 0}, {2, 1}, {3, 2}};
        int numCourses = 4;
        System.out.println("Can finish all courses: " + checker.canFinish(numCourses, prerequisites));
    }
}

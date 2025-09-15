import java.util.*;

public class day78_course_schedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<numCourses;i++) graph.add(new ArrayList<>());
        int[] indegree=new int[numCourses];
        for(int[] pre:prerequisites) {
            graph.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++) if(indegree[i]==0) q.offer(i);
        int visited=0;
        while(!q.isEmpty()) {
            int course=q.poll(); visited++;
            for(int next:graph.get(course)) {
                if(--indegree[next]==0) q.offer(next);
            }
        }
        return visited==numCourses;
    }

    public static void main(String[] args) {
        int[][] prereq={{1,0},{2,1},{3,2}};
        System.out.println("Can finish courses? "+canFinish(4,prereq));
    }
}

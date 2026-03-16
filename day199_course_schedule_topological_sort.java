import java.util.*;

public class day199_course_schedule_topological_sort {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for(int i=0;i<numCourses;i++)
            adj.add(new ArrayList<>());

        for(int[] p : prerequisites){
            adj.get(p[1]).add(p[0]);
            indegree[p[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<numCourses;i++)
            if(indegree[i]==0)
                q.add(i);

        int count = 0;

        while(!q.isEmpty()){

            int node = q.poll();
            count++;

            for(int nei : adj.get(node)){
                if(--indegree[nei] == 0)
                    q.add(nei);
            }
        }

        return count == numCourses;
    }

    public static void main(String[] args) {

        int[][] pre = {{1,0},{2,1}};
        System.out.println(canFinish(3,pre));
    }
}
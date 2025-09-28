import java.util.*;

public class day92_course_schedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<numCourses;i++) graph.add(new ArrayList<>());
        int[] indegree=new int[numCourses];
        for(int[] p:prerequisites){
            graph.get(p[1]).add(p[0]);
            indegree[p[0]]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++) if(indegree[i]==0) q.add(i);
        int count=0;
        while(!q.isEmpty()){
            int cur=q.poll(); count++;
            for(int nb:graph.get(cur)){
                if(--indegree[nb]==0) q.add(nb);
            }
        }
        return count==numCourses;
    }
    public static void main(String[] args){
        int[][] pre={{1,0},{2,1}};
        System.out.println(canFinish(3,pre));
    }
}

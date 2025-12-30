import java.util.*;

public class day174_graph_bfs {
    public static void bfs(List<List<Integer>> g, int start){
        boolean[] visited=new boolean[g.size()];
        Queue<Integer> q=new LinkedList<>();

        visited[start]=true;
        q.add(start);

        while(!q.isEmpty()){
            int u=q.poll();
            System.out.print(u+" ");

            for(int v : g.get(u)){
                if(!visited[v]){
                    visited[v]=true;
                    q.add(v);
                }
            }
        }
    }

    public static void main(String[] args){
        List<List<Integer>> g=new ArrayList<>();
        for(int i=0;i<5;i++) g.add(new ArrayList<>());

        g.get(0).add(1); g.get(0).add(2);
        g.get(1).add(3); g.get(2).add(4);

        bfs(g,0);
    }
}
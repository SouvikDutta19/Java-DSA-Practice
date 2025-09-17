import java.util.*;

public class day81_bipartite_graph {
    public static boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] color=new int[n];
        Arrays.fill(color,-1);
        for(int start=0;start<n;start++) {
            if(color[start]==-1) {
                Queue<Integer> q=new LinkedList<>();
                q.add(start); color[start]=0;
                while(!q.isEmpty()) {
                    int node=q.poll();
                    for(int nei:graph[node]) {
                        if(color[nei]==-1) {
                            color[nei]=color[node]^1;
                            q.add(nei);
                        } else if(color[nei]==color[node])
                            return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] graph={{1,3},{0,2},{1,3},{0,2}};
        System.out.println("Is Bipartite? "+isBipartite(graph));
    }
}

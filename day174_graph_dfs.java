import java.util.*;

public class day174_graph_dfs {
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    public static void dfs(int node){
        visited[node] = true;
        System.out.print(node+" ");

        for(int v : graph.get(node)){
            if(!visited[v]) dfs(v);
        }
    }

    public static void main(String[] args){
        int V=5;
        visited=new boolean[V];

        for(int i=0;i<V;i++) graph.add(new ArrayList<>());

        graph.get(0).add(1); graph.get(0).add(2);
        graph.get(1).add(3); graph.get(2).add(4);

        dfs(0);
    }
}
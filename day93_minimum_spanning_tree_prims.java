import java.util.*;

public class day93_minimum_spanning_tree_prims {
    public static int primMST(int[][] graph){
        int V=graph.length;
        int[] key=new int[V]; boolean[] mstSet=new boolean[V];
        Arrays.fill(key,Integer.MAX_VALUE); key[0]=0;
        int res=0;
        for(int count=0;count<V;count++){
            int u=-1;
            for(int i=0;i<V;i++) if(!mstSet[i] && (u==-1||key[i]<key[u])) u=i;
            mstSet[u]=true; res+=key[u];
            for(int v=0;v<V;v++) if(graph[u][v]!=0 && !mstSet[v] && graph[u][v]<key[v]) key[v]=graph[u][v];
        }
        return res;
    }
    public static void main(String[] args){
        int[][] graph={{0,2,0,6,0},{2,0,3,8,5},{0,3,0,0,7},{6,8,0,0,9},{0,5,7,9,0}};
        System.out.println("MST weight: "+primMST(graph));
    }
}

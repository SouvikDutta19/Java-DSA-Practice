import java.util.*;

public class day93_longest_path_dag {
    static void topologicalSortUtil(int v,boolean[] vis,Stack<Integer> st,List<List<int[]>> g){
        vis[v]=true;
        for(int[] nb:g.get(v)) if(!vis[nb[0]]) topologicalSortUtil(nb[0],vis,st,g);
        st.push(v);
    }
    static void longestPath(List<List<int[]>> g,int s){
        int V=g.size();
        Stack<Integer> st=new Stack<>();
        boolean[] vis=new boolean[V];
        for(int i=0;i<V;i++) if(!vis[i]) topologicalSortUtil(i,vis,st,g);
        int[] dist=new int[V]; Arrays.fill(dist,Integer.MIN_VALUE); dist[s]=0;
        while(!st.isEmpty()){
            int u=st.pop();
            if(dist[u]!=Integer.MIN_VALUE){
                for(int[] nb:g.get(u)){
                    if(dist[nb[0]]<dist[u]+nb[1]) dist[nb[0]]=dist[u]+nb[1];
                }
            }
        }
        System.out.println("Longest path from "+s+": "+Arrays.toString(dist));
    }
    public static void main(String[] args){
        int V=6;
        List<List<int[]>> g=new ArrayList<>();
        for(int i=0;i<V;i++) g.add(new ArrayList<>());
        g.get(0).add(new int[]{1,5}); g.get(0).add(new int[]{2,3});
        g.get(1).add(new int[]{3,6}); g.get(1).add(new int[]{2,2});
        g.get(2).add(new int[]{4,4}); g.get(2).add(new int[]{5,2}); g.get(2).add(new int[]{3,7});
        g.get(3).add(new int[]{5,1}); g.get(3).add(new int[]{4,-1});
        g.get(4).add(new int[]{5,-2});
        longestPath(g,1);
    }
}

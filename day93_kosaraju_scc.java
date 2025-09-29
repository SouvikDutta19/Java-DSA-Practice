import java.util.*;

public class day93_kosaraju_scc {
    static void dfs1(int v,boolean[] vis,Stack<Integer> st,List<List<Integer>> g){
        vis[v]=true;
        for(int nb:g.get(v)) if(!vis[nb]) dfs1(nb,vis,st,g);
        st.push(v);
    }
    static void dfs2(int v,boolean[] vis,List<List<Integer>> g){
        vis[v]=true;
        System.out.print(v+" ");
        for(int nb:g.get(v)) if(!vis[nb]) dfs2(nb,vis,g);
    }
    public static void main(String[] args){
        int V=5;
        List<List<Integer>> g=new ArrayList<>(), gr=new ArrayList<>();
        for(int i=0;i<V;i++){g.add(new ArrayList<>());gr.add(new ArrayList<>());}
        g.get(1).add(0); g.get(0).add(2); g.get(2).add(1); g.get(0).add(3); g.get(3).add(4);
        for(int i=0;i<V;i++) for(int j:g.get(i)) gr.get(j).add(i);
        Stack<Integer> st=new Stack<>();
        boolean[] vis=new boolean[V];
        for(int i=0;i<V;i++) if(!vis[i]) dfs1(i,vis,st,g);
        Arrays.fill(vis,false);
        while(!st.isEmpty()){
            int v=st.pop();
            if(!vis[v]){ dfs2(v,vis,gr); System.out.println(); }
        }
    }
}

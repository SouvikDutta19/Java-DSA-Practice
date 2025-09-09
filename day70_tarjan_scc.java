import java.util.*;

public class day70_tarjan_scc {
    static int time=0;
    static void dfs(int u,List<List<Integer>> adj,int[] disc,int[] low,Stack<Integer> st,boolean[] inStack){
        disc[u]=low[u]=++time; st.push(u); inStack[u]=true;
        for(int v:adj.get(u)){
            if(disc[v]==-1){ dfs(v,adj,disc,low,st,inStack); low[u]=Math.min(low[u],low[v]); }
            else if(inStack[v]) low[u]=Math.min(low[u],disc[v]);
        }
        if(disc[u]==low[u]){
            while(true){
                int v=st.pop(); inStack[v]=false;
                System.out.print(v+" ");
                if(v==u) break;
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        int n=5;
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        adj.get(1).add(0); adj.get(0).add(2); adj.get(2).add(1);
        adj.get(0).add(3); adj.get(3).add(4);

        int[] disc=new int[n], low=new int[n]; Arrays.fill(disc,-1);
        Stack<Integer> st=new Stack<>(); boolean[] inStack=new boolean[n];
        for(int i=0;i<n;i++) if(disc[i]==-1) dfs(i,adj,disc,low,st,inStack);
    }
}

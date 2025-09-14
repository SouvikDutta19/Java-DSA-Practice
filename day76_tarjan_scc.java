import java.util.*;

public class day76_tarjan_scc {
    private int V,time;
    private List<List<Integer>> adj;
    private int[] disc,low;
    private boolean[] stackMember;
    private Stack<Integer> st;

    day76_tarjan_scc(int v){
        V=v; adj=new ArrayList<>();
        for(int i=0;i<v;i++) adj.add(new ArrayList<>());
        disc=new int[v]; low=new int[v];
        stackMember=new boolean[v]; st=new Stack<>();
        Arrays.fill(disc,-1);
    }

    void addEdge(int u,int v){ adj.get(u).add(v); }

    void SCCUtil(int u){
        disc[u]=low[u]=++time;
        st.push(u); stackMember[u]=true;
        for(int v:adj.get(u)){
            if(disc[v]==-1){
                SCCUtil(v); low[u]=Math.min(low[u],low[v]);
            } else if(stackMember[v]) low[u]=Math.min(low[u],disc[v]);
        }
        if(low[u]==disc[u]){
            while(true){
                int v=st.pop(); stackMember[v]=false;
                System.out.print(v+" ");
                if(v==u) break;
            }
            System.out.println();
        }
    }

    void SCC(){ for(int i=0;i<V;i++) if(disc[i]==-1) SCCUtil(i); }

    public static void main(String[] args){
        day76_tarjan_scc g=new day76_tarjan_scc(5);
        g.addEdge(1,0); g.addEdge(0,2); g.addEdge(2,1);
        g.addEdge(0,3); g.addEdge(3,4);
        System.out.println("Strongly Connected Components:");
        g.SCC();
    }
}

import java.util.*;

public class day76_kosaraju_scc {
    private int V;
    private List<List<Integer>> adj;

    day76_kosaraju_scc(int v){
        V=v;
        adj=new ArrayList<>();
        for(int i=0;i<v;i++) adj.add(new ArrayList<>());
    }

    void addEdge(int u,int v){ adj.get(u).add(v); }

    void DFS(int v, boolean[] visited, Stack<Integer> st){
        visited[v]=true;
        for(int n:adj.get(v)) if(!visited[n]) DFS(n,visited,st);
        st.push(v);
    }

    day76_kosaraju_scc getTranspose(){
        day76_kosaraju_scc g=new day76_kosaraju_scc(V);
        for(int i=0;i<V;i++) for(int v:adj.get(i)) g.addEdge(v,i);
        return g;
    }

    void fillOrder(int v,boolean[] visited,Stack<Integer> st){
        visited[v]=true;
        for(int n:adj.get(v)) if(!visited[n]) fillOrder(n,visited,st);
        st.push(v);
    }

    void DFSUtil(int v,boolean[] visited){
        visited[v]=true;
        System.out.print(v+" ");
        for(int n:adj.get(v)) if(!visited[n]) DFSUtil(n,visited);
    }

    void printSCCs(){
        Stack<Integer> st=new Stack<>();
        boolean[] visited=new boolean[V];
        for(int i=0;i<V;i++) if(!visited[i]) fillOrder(i,visited,st);
        day76_kosaraju_scc gr=getTranspose();
        Arrays.fill(visited,false);
        while(!st.isEmpty()){
            int v=st.pop();
            if(!visited[v]){
                gr.DFSUtil(v,visited);
                System.out.println();
            }
        }
    }

    public static void main(String[] args){
        day76_kosaraju_scc g=new day76_kosaraju_scc(5);
        g.addEdge(1,0); g.addEdge(0,2); g.addEdge(2,1);
        g.addEdge(0,3); g.addEdge(3,4);
        System.out.println("Strongly Connected Components:");
        g.printSCCs();
    }
}

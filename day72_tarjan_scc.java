import java.util.*;

public class day72_tarjan_scc {
    static List<Integer>[] adj;
    static int time=0, n;
    static int[] disc, low;
    static boolean[] stackMember;
    static Stack<Integer> stack;

    static void SCCUtil(int u){
        disc[u]=low[u]=++time;
        stack.push(u); stackMember[u]=true;

        for(int v:adj[u]){
            if(disc[v]==-1){
                SCCUtil(v); low[u]=Math.min(low[u],low[v]);
            } else if(stackMember[v]) low[u]=Math.min(low[u],disc[v]);
        }

        if(low[u]==disc[u]){
            while(true){
                int v=stack.pop(); stackMember[v]=false;
                System.out.print(v+" ");
                if(v==u) break;
            }
            System.out.println();
        }
    }

    static void SCC(){
        disc=new int[n]; low=new int[n];
        Arrays.fill(disc,-1); Arrays.fill(low,-1);
        stackMember=new boolean[n]; stack=new Stack<>();
        for(int i=0;i<n;i++) if(disc[i]==-1) SCCUtil(i);
    }

    public static void main(String[] args){
        n=5;
        adj=new ArrayList[n];
        for(int i=0;i<n;i++) adj[i]=new ArrayList<>();
        adj[1].add(0);
        adj[0].add(2); adj[2].add(1);
        adj[0].add(3); adj[3].add(4);
        SCC();
    }
}

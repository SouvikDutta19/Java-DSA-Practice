import java.util.*;

public class day67_bipartite_check {
    static boolean isBipartite(List<List<Integer>> adj,int n){
        int[] color=new int[n];
        Arrays.fill(color,-1);
        for(int start=0;start<n;start++){
            if(color[start]==-1){
                Queue<Integer> q=new LinkedList<>();
                q.add(start); color[start]=0;
                while(!q.isEmpty()){
                    int u=q.poll();
                    for(int v:adj.get(u)){
                        if(color[v]==-1){ color[v]=color[u]^1; q.add(v); }
                        else if(color[v]==color[u]) return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args){
        int n=4;
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        adj.get(0).add(1); adj.get(1).add(0);
        adj.get(1).add(2); adj.get(2).add(1);
        adj.get(2).add(3); adj.get(3).add(2);
        adj.get(3).add(0); adj.get(0).add(3);
        System.out.println(isBipartite(adj,n));
    }
}

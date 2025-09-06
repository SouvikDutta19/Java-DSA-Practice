import java.io.*;
import java.util.*;

public class day67_topological_sort_kahn {
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken()), m=Integer.parseInt(st.nextToken());
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        int[] indeg=new int[n];
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken()), v=Integer.parseInt(st.nextToken());
            adj.get(u).add(v); indeg[v]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++) if(indeg[i]==0) q.add(i);
        List<Integer> topo=new ArrayList<>();
        while(!q.isEmpty()){
            int u=q.poll(); topo.add(u);
            for(int v:adj.get(u)){ if(--indeg[v]==0) q.add(v); }
        }
        System.out.println(topo);
    }
}

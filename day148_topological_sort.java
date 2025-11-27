// Day148 Topological Sort (Kahn's algorithm)
import java.util.*;
public class Day148TopologicalSort {
    public static int[] topoSort(int n, List<int[]> edges){
        List<List<Integer>> g = new ArrayList<>();
        int[] indeg = new int[n];
        for(int i=0;i<n;i++) g.add(new ArrayList<>());
        for(int[] e: edges){
            g.get(e[0]).add(e[1]);
            indeg[e[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++) if(indeg[i]==0) q.add(i);
        int[] order = new int[n];
        int idx=0;
        while(!q.isEmpty()){
            int u = q.poll();
            order[idx++] = u;
            for(int v: g.get(u)){
                if(--indeg[v]==0) q.add(v);
            }
        }
        if(idx != n) return new int[0]; // cycle
        return order;
    }

    public static void main(String[] args){
        int n = 6;
        List<int[]> edges = Arrays.asList(new int[]{5,2}, new int[]{5,0}, new int[]{4,0},
                                         new int[]{4,1}, new int[]{2,3}, new int[]{3,1});
        int[] ord = topoSort(n, edges);
        System.out.println("Topological order:");
        for(int v: ord) System.out.print(v + " ");
        System.out.println();
    }
}

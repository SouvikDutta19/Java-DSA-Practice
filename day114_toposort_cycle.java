// day114_toposort_cycle.java
// Topological sort using Kahn's algorithm with cycle detection.
// If a cycle exists, prints "CYCLE", else prints one topological order.
import java.util.*;
class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        List<List<Integer>> g = new ArrayList<>();
        for(int i=0;i<n;i++) g.add(new ArrayList<>());
        int[] indeg = new int[n];
        for(int i=0;i<m;i++){
            int u = sc.nextInt(), v = sc.nextInt(); // edge u -> v
            g.get(u).add(v);
            indeg[v]++;
        }
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0;i<n;i++) if(indeg[i]==0) q.add(i);
        List<Integer> order = new ArrayList<>();
        while(!q.isEmpty()){
            int u = q.poll();
            order.add(u);
            for(int v: g.get(u)){
                if(--indeg[v]==0) q.add(v);
            }
        }
        if(order.size() != n){
            System.out.println("CYCLE");
        } else {
            for(int x: order) System.out.print(x + " ");
            System.out.println();
        }
        sc.close();
    }
}

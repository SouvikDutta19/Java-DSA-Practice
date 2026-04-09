import java.util.*;

public class day207_strongly_connected_components_tarjan {

    static int time = 0;

    public static List<List<Integer>> tarjanSCC(int V, List<List<Integer>> adj){

        int[] disc = new int[V];
        int[] low = new int[V];
        boolean[] inStack = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        Arrays.fill(disc, -1);

        List<List<Integer>> result = new ArrayList<>();

        for(int i=0;i<V;i++){
            if(disc[i] == -1)
                dfs(i, adj, disc, low, inStack, stack, result);
        }

        return result;
    }

    static void dfs(int u, List<List<Integer>> adj,
                    int[] disc, int[] low,
                    boolean[] inStack, Stack<Integer> stack,
                    List<List<Integer>> result){

        disc[u] = low[u] = time++;
        stack.push(u);
        inStack[u] = true;

        for(int v : adj.get(u)){

            if(disc[v] == -1){
                dfs(v, adj, disc, low, inStack, stack, result);
                low[u] = Math.min(low[u], low[v]);
            }
            else if(inStack[v]){
                low[u] = Math.min(low[u], disc[v]);
            }
        }

        if(low[u] == disc[u]){
            List<Integer> component = new ArrayList<>();

            while(true){
                int node = stack.pop();
                inStack[node] = false;
                component.add(node);

                if(node == u) break;
            }
            result.add(component);
        }
    }
}
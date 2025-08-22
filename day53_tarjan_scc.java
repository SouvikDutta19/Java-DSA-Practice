import java.util.*;

public class day53_tarjan_scc {
    private int time = 0;
    private Stack<Integer> stack;
    private boolean[] onStack;
    private int[] ids, low;
    private List<List<Integer>> sccs;

    public List<List<Integer>> tarjanSCC(int n, List<Integer>[] graph) {
        stack = new Stack<>();
        onStack = new boolean[n];
        ids = new int[n];
        low = new int[n];
        Arrays.fill(ids, -1);
        sccs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (ids[i] == -1) dfs(i, graph);
        }
        return sccs;
    }

    private void dfs(int at, List<Integer>[] graph) {
        stack.push(at);
        onStack[at] = true;
        ids[at] = low[at] = time++;

        for (int to : graph[at]) {
            if (ids[to] == -1) dfs(to, graph);
            if (onStack[to]) low[at] = Math.min(low[at], low[to]);
        }

        if (ids[at] == low[at]) {
            List<Integer> scc = new ArrayList<>();
            while (true) {
                int node = stack.pop();
                onStack[node] = false;
                low[node] = ids[at];
                scc.add(node);
                if (node == at) break;
            }
            sccs.add(scc);
        }
    }

    public static void main(String[] args) {
        int V = 5;
        List<Integer>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) graph[i] = new ArrayList<>();

        graph[0].add(1);
        graph[1].add(2);
        graph[2].add(0);
        graph[1].add(3);
        graph[3].add(4);

        day53_tarjan_scc solver = new day53_tarjan_scc();
        List<List<Integer>> result = solver.tarjanSCC(V, graph);
        System.out.println("Strongly Connected Components: " + result);
    }
}

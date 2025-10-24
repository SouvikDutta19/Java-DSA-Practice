import java.util.*;
// Tarjan's algorithm to compute Strongly Connected Components (SCCs)
public class day117_tarjan_scc {
    int N, time = 0;
    List<Integer>[] g;
    int[] disc, low;
    boolean[] inStack;
    Deque<Integer> stack;
    List<List<Integer>> sccs;

    @SuppressWarnings("unchecked")
    public day117_tarjan_scc(int n) {
        N = n;
        g = new List[N];
        for (int i = 0; i < N; i++) g[i] = new ArrayList<>();
        disc = new int[N]; Arrays.fill(disc, -1);
        low = new int[N];
        inStack = new boolean[N];
        stack = new ArrayDeque<>();
        sccs = new ArrayList<>();
    }

    void addEdge(int u, int v) { g[u].add(v); }

    void dfs(int u) {
        disc[u] = low[u] = time++;
        stack.push(u);
        inStack[u] = true;
        for (int v : g[u]) {
            if (disc[v] == -1) {
                dfs(v);
                low[u] = Math.min(low[u], low[v]);
            } else if (inStack[v]) low[u] = Math.min(low[u], disc[v]);
        }
        if (low[u] == disc[u]) {
            List<Integer> comp = new ArrayList<>();
            int w;
            do {
                w = stack.pop();
                inStack[w] = false;
                comp.add(w);
            } while (w != u);
            sccs.add(comp);
        }
    }

    List<List<Integer>> getSCCs() {
        for (int i = 0; i < N; i++) if (disc[i] == -1) dfs(i);
        return sccs;
    }

    public static void main(String[] args) {
        day117_tarjan_scc t = new day117_tarjan_scc(5);
        t.addEdge(1,0); t.addEdge(0,2); t.addEdge(2,1); t.addEdge(0,3); t.addEdge(3,4);
        List<List<Integer>> sccs = t.getSCCs();
        System.out.println("SCCs:");
        for (List<Integer> c : sccs) System.out.println(c);
    }
}

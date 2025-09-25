import java.util.*;

public class day90_kosaraju_scc {
    private int V;
    private List<List<Integer>> adj;

    day90_kosaraju_scc(int v) {
        V = v;
        adj = new ArrayList<>();
        for (int i = 0; i < v; i++) adj.add(new ArrayList<>());
    }

    void addEdge(int v, int w) { adj.get(v).add(w); }

    void fillOrder(int v, boolean visited[], Stack<Integer> stack) {
        visited[v] = true;
        for (int n : adj.get(v)) if (!visited[n]) fillOrder(n, visited, stack);
        stack.push(v);
    }

    void DFSUtil(int v, boolean visited[], List<List<Integer>> adj) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int n : adj.get(v)) if (!visited[n]) DFSUtil(n, visited, adj);
    }

    List<List<Integer>> getTranspose() {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < V; i++) g.add(new ArrayList<>());
        for (int v = 0; v < V; v++) for (int n : adj.get(v)) g.get(n).add(v);
        return g;
    }

    void printSCCs() {
        Stack<Integer> stack = new Stack<>();
        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++) if (!visited[i]) fillOrder(i, visited, stack);

        List<List<Integer>> gr = getTranspose();
        Arrays.fill(visited, false);

        while (!stack.isEmpty()) {
            int v = stack.pop();
            if (!visited[v]) {
                DFSUtil(v, visited, gr);
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        day90_kosaraju_scc g = new day90_kosaraju_scc(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);
        g.printSCCs();
    }
}

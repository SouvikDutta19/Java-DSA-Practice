import java.util.*;

public class day58_kosarajustrongcomponents {
    private int V;
    private LinkedList<Integer>[] adj;

    public day58_kosarajustrongcomponents(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) adj[i] = new LinkedList<>();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void fillOrder(int v, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;
        for (int n : adj[v]) {
            if (!visited[n])
                fillOrder(n, visited, stack);
        }
        stack.push(v);
    }

    day58_kosarajustrongcomponents getTranspose() {
        day58_kosarajustrongcomponents g = new day58_kosarajustrongcomponents(V);
        for (int v = 0; v < V; v++) {
            for (int n : adj[v]) {
                g.addEdge(n, v);
            }
        }
        return g;
    }

    void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int n : adj[v]) {
            if (!visited[n]) DFSUtil(n, visited);
        }
    }

    void printSCCs() {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++)
            if (!visited[i])
                fillOrder(i, visited, stack);
        day58_kosarajustrongcomponents gr = getTranspose();
        Arrays.fill(visited, false);
        while (!stack.isEmpty()) {
            int v = stack.pop();
            if (!visited[v]) {
                gr.DFSUtil(v, visited);
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        day58_kosarajustrongcomponents g = new day58_kosarajustrongcomponents(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);
        System.out.println("Strongly Connected Components:");
        g.printSCCs();
    }
}

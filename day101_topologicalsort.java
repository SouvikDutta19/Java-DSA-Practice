import java.util.*;

public class day101_topologicalsort {
    private int V;
    private LinkedList<Integer> adj[];

    day101_topologicalsort(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<>();
    }

    void addEdge(int v, int w) { adj[v].add(w); }

    void topologicalSortUtil(int v, boolean visited[], Stack<Integer> stack) {
        visited[v] = true;
        for (int i : adj[v])
            if (!visited[i])
                topologicalSortUtil(i, visited, stack);
        stack.push(v);
    }

    void topologicalSort() {
        Stack<Integer> stack = new Stack<>();
        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++)
            if (!visited[i])
                topologicalSortUtil(i, visited, stack);

        while (!stack.isEmpty())
            System.out.print(stack.pop() + " ");
    }

    public static void main(String args[]) {
        day101_topologicalsort g = new day101_topologicalsort(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        g.topologicalSort();
    }
}

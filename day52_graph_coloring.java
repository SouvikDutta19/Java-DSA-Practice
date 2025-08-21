import java.util.*;

public class day52_graph_coloring {
    private int V;
    private int[][] graph;
    private int[] colors;

    public day52_graph_coloring(int v) {
        V = v;
        graph = new int[V][V];
        colors = new int[V];
    }

    public void addEdge(int u, int v) {
        graph[u][v] = 1;
        graph[v][u] = 1;
    }

    public boolean isSafe(int v, int c) {
        for (int i = 0; i < V; i++) {
            if (graph[v][i] == 1 && colors[i] == c)
                return false;
        }
        return true;
    }

    public boolean graphColoringUtil(int m, int v) {
        if (v == V) return true;
        for (int c = 1; c <= m; c++) {
            if (isSafe(v, c)) {
                colors[v] = c;
                if (graphColoringUtil(m, v + 1)) return true;
                colors[v] = 0;
            }
        }
        return false;
    }

    public boolean graphColoring(int m) {
        Arrays.fill(colors, 0);
        if (!graphColoringUtil(m, 0)) {
            System.out.println("Solution does not exist");
            return false;
        }
        System.out.println("Graph coloring solution:");
        for (int i = 0; i < V; i++) {
            System.out.print("Vertex " + i + " -> Color " + colors[i] + "\n");
        }
        return true;
    }

    public static void main(String[] args) {
        day52_graph_coloring g = new day52_graph_coloring(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.graphColoring(3);
    }
}

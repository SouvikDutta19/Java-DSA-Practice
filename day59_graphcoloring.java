import java.util.*;

class GraphColoring {
    private int V;
    private int[][] graph;

    public GraphColoring(int v) {
        V = v;
        graph = new int[V][V];
    }

    public void addEdge(int u, int v) {
        graph[u][v] = 1;
        graph[v][u] = 1;
    }

    private boolean isSafe(int v, int[] color, int c) {
        for (int i = 0; i < V; i++) {
            if (graph[v][i] == 1 && color[i] == c) return false;
        }
        return true;
    }

    private boolean graphColoringUtil(int m, int[] color, int v) {
        if (v == V) return true;

        for (int c = 1; c <= m; c++) {
            if (isSafe(v, color, c)) {
                color[v] = c;
                if (graphColoringUtil(m, color, v + 1)) return true;
                color[v] = 0;
            }
        }
        return false;
    }

    public void graphColoring(int m) {
        int[] color = new int[V];
        if (!graphColoringUtil(m, color, 0)) {
            System.out.println("Solution does not exist");
            return;
        }

        System.out.println("Assigned Colors:");
        for (int i = 0; i < V; i++) {
            System.out.print(color[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        GraphColoring g = new GraphColoring(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(1, 3);

        int m = 3; // Number of colors
        g.graphColoring(m);
    }
}

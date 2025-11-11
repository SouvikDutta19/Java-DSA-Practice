// day135_graph_coloring_backtracking.java
// Graph coloring using backtracking (m-coloring problem)

import java.util.*;

public class day135_graph_coloring_backtracking {
    private int V;
    private int[][] graph;
    private int[] color;

    public day135_graph_coloring_backtracking(int V) {
        this.V = V;
        graph = new int[V][V];
        color = new int[V];
    }

    public void addEdge(int u, int v) {
        graph[u][v] = 1;
        graph[v][u] = 1;
    }

    private boolean isSafe(int v, int c) {
        for (int i = 0; i < V; i++)
            if (graph[v][i] == 1 && color[i] == c) return false;
        return true;
    }

    private boolean graphColoringUtil(int m, int v) {
        if (v == V) return true;
        for (int c = 1; c <= m; c++) {
            if (isSafe(v, c)) {
                color[v] = c;
                if (graphColoringUtil(m, v + 1)) return true;
                color[v] = 0;
            }
        }
        return false;
    }

    public void graphColoring(int m) {
        if (!graphColoringUtil(m, 0)) {
            System.out.println("No solution exists with " + m + " colors");
            return;
        }
        System.out.println("Coloring of graph:");
        for (int i = 0; i < V; i++) System.out.print(color[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        day135_graph_coloring_backtracking g = new day135_graph_coloring_backtracking(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        int m = 3;
        g.graphColoring(m);
    }
}

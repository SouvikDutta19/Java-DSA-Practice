import java.util.*;

// Graph Coloring Problem using Backtracking
public class day108_graph_coloring {
    final int V = 4;
    int[] color;

    boolean isSafe(boolean[][] graph, int v, int[] color, int c) {
        for (int i = 0; i < V; i++)
            if (graph[v][i] && c == color[i]) return false;
        return true;
    }

    boolean graphColoringUtil(boolean[][] graph, int m, int v) {
        if (v == V) return true;
        for (int c = 1; c <= m; c++) {
            if (isSafe(graph, v, color, c)) {
                color[v] = c;
                if (graphColoringUtil(graph, m, v + 1)) return true;
                color[v] = 0;
            }
        }
        return false;
    }

    void graphColoring(boolean[][] graph, int m) {
        color = new int[V];
        if (!graphColoringUtil(graph, m, 0))
            System.out.println("Solution does not exist");
        else {
            System.out.println("Solution Exists: Following are the assigned colors:");
            for (int i = 0; i < V; i++) System.out.print(color[i] + " ");
        }
    }

    public static void main(String[] args) {
        boolean[][] graph = {
            {false, true, true, true},
            {true, false, true, false},
            {true, true, false, true},
            {true, false, true, false}
        };
        int m = 3;
        new day108_graph_coloring().graphColoring(graph, m);
    }
}

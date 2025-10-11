import java.util.*;

// M-Coloring Problem using Backtracking
public class day105_graph_coloring {
    public static boolean isSafe(int v, int[][] graph, int[] color, int c) {
        for (int i = 0; i < graph.length; i++)
            if (graph[v][i] == 1 && color[i] == c)
                return false;
        return true;
    }

    public static boolean graphColoringUtil(int[][] graph, int m, int[] color, int v) {
        if (v == graph.length)
            return true;
        for (int c = 1; c <= m; c++) {
            if (isSafe(v, graph, color, c)) {
                color[v] = c;
                if (graphColoringUtil(graph, m, color, v + 1))
                    return true;
                color[v] = 0;
            }
        }
        return false;
    }

    public static void solveGraphColoring(int[][] graph, int m) {
        int[] color = new int[graph.length];
        if (!graphColoringUtil(graph, m, color, 0))
            System.out.println("No solution exists");
        else
            System.out.println("Assigned colors: " + Arrays.toString(color));
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 1, 1, 1},
            {1, 0, 1, 0},
            {1, 1, 0, 1},
            {1, 0, 1, 0}
        };
        int m = 3;
        solveGraphColoring(graph, m);
    }
}

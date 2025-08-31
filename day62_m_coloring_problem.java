import java.util.*;

public class day62_m_coloring_problem {
    static int V = 4;

    static boolean isSafe(int v, int[] color, boolean[][] graph, int c) {
        for (int i = 0; i < V; i++) {
            if (graph[v][i] && c == color[i]) return false;
        }
        return true;
    }

    static boolean graphColoringUtil(boolean[][] graph, int m, int[] color, int v) {
        if (v == V) return true;
        for (int c = 1; c <= m; c++) {
            if (isSafe(v, color, graph, c)) {
                color[v] = c;
                if (graphColoringUtil(graph, m, color, v + 1)) return true;
                color[v] = 0;
            }
        }
        return false;
    }

    static boolean graphColoring(boolean[][] graph, int m) {
        int[] color = new int[V];
        if (!graphColoringUtil(graph, m, color, 0)) {
            System.out.println("No solution");
            return false;
        }
        System.out.println("Graph Coloring Solution:");
        for (int i = 0; i < V; i++)
            System.out.print(color[i] + " ");
        return true;
    }

    public static void main(String[] args) {
        boolean[][] graph = {
            {false, true, true, true},
            {true, false, true, false},
            {true, true, false, true},
            {true, false, true, false},
        };
        int m = 3;
        graphColoring(graph, m);
    }
}

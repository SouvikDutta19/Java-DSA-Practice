import java.util.*;

public class day116_graph_coloring_backtracking {
    final int V = 4;
    int[] color;

    boolean isSafe(int v, boolean[][] graph, int[] color, int c) {
        for (int i = 0; i < V; i++)
            if (graph[v][i] && c == color[i])
                return false;
        return true;
    }

    boolean graphColoringUtil(boolean[][] graph, int m, int[] color, int v) {
        if (v == V)
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

    boolean graphColoring(boolean[][] graph, int m) {
        color = new int[V];
        if (!graphColoringUtil(graph, m, color, 0)) {
            System.out.println("Solution does not exist");
            return false;
        }
        printSolution(color);
        return true;
    }

    void printSolution(int[] color) {
        System.out.println("Color assignment:");
        for (int i = 0; i < V; i++)
            System.out.print("Vertex " + i + " -> Color " + color[i] + "\n");
    }

    public static void main(String[] args) {
        day116_graph_coloring_backtracking g = new day116_graph_coloring_backtracking();
        boolean[][] graph = {
            {false, true, true, true},
            {true, false, true, false},
            {true, true, false, true},
            {true, false, true, false}
        };
        int m = 3;
        g.graphColoring(graph, m);
    }
}

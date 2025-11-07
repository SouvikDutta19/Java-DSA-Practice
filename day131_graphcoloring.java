// day131_graphcoloring.java
import java.util.*;

public class day131_graphcoloring {
    private int vertices;
    private int[][] graph;
    private int[] colors;

    public day131_graphcoloring(int vertices) {
        this.vertices = vertices;
        graph = new int[vertices][vertices];
        colors = new int[vertices];
    }

    public void addEdge(int v1, int v2) {
        graph[v1][v2] = 1;
        graph[v2][v1] = 1;
    }

    public boolean isSafe(int v, int c) {
        for (int i = 0; i < vertices; i++)
            if (graph[v][i] == 1 && colors[i] == c)
                return false;
        return true;
    }

    public boolean graphColoringUtil(int m, int v) {
        if (v == vertices)
            return true;
        for (int c = 1; c <= m; c++) {
            if (isSafe(v, c)) {
                colors[v] = c;
                if (graphColoringUtil(m, v + 1))
                    return true;
                colors[v] = 0;
            }
        }
        return false;
    }

    public void graphColoring(int m) {
        if (!graphColoringUtil(m, 0)) {
            System.out.println("No solution exists");
            return;
        }
        System.out.println("Color assignment:");
        for (int i = 0; i < vertices; i++)
            System.out.print(" " + colors[i]);
    }

    public static void main(String[] args) {
        day131_graphcoloring g = new day131_graphcoloring(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.graphColoring(3);
    }
}

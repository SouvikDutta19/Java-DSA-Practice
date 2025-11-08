// day132_hamiltoniancycle.java
import java.util.*;

public class day132_hamiltoniancycle {
    private int V;
    private int path[];
    private int[][] graph;

    public day132_hamiltoniancycle(int[][] graph) {
        this.graph = graph;
        this.V = graph.length;
        path = new int[V];
        Arrays.fill(path, -1);
    }

    boolean isSafe(int v, int pos) {
        if (graph[path[pos - 1]][v] == 0)
            return false;
        for (int i = 0; i < pos; i++)
            if (path[i] == v)
                return false;
        return true;
    }

    boolean hamCycleUtil(int pos) {
        if (pos == V) {
            return graph[path[pos - 1]][path[0]] == 1;
        }
        for (int v = 1; v < V; v++) {
            if (isSafe(v, pos)) {
                path[pos] = v;
                if (hamCycleUtil(pos + 1))
                    return true;
                path[pos] = -1;
            }
        }
        return false;
    }

    void hamCycle() {
        path[0] = 0;
        if (!hamCycleUtil(1)) {
            System.out.println("No Hamiltonian cycle exists");
            return;
        }
        System.out.println("Hamiltonian Cycle found:");
        for (int v : path) System.out.print(v + " ");
        System.out.println(path[0]);
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 1, 0, 1, 0},
            {1, 0, 1, 1, 1},
            {0, 1, 0, 0, 1},
            {1, 1, 0, 0, 1},
            {0, 1, 1, 1, 0}
        };
        new day132_hamiltoniancycle(graph).hamCycle();
    }
}

import java.util.*;

public class day41_hamiltonian_cycle {
    final int V = 5;
    int path[];

    boolean isSafe(int v, int graph[][], int path[], int pos) {
        if (graph[path[pos - 1]][v] == 0) return false;
        for (int i = 0; i < pos; i++)
            if (path[i] == v) return false;
        return true;
    }

    boolean hamCycleUtil(int graph[][], int path[], int pos) {
        if (pos == V) {
            return graph[path[pos - 1]][path[0]] == 1;
        }

        for (int v = 1; v < V; v++) {
            if (isSafe(v, graph, path, pos)) {
                path[pos] = v;
                if (hamCycleUtil(graph, path, pos + 1)) return true;
                path[pos] = -1;
            }
        }
        return false;
    }

    int[] hamCycle(int graph[][]) {
        path = new int[V];
        Arrays.fill(path, -1);
        path[0] = 0;
        if (!hamCycleUtil(graph, path, 1)) {
            return new int[]{};
        }
        return path;
    }

    public static void main(String[] args) {
        day41_hamiltonian_cycle h = new day41_hamiltonian_cycle();
        int graph[][] = {
            {0, 1, 0, 1, 0},
            {1, 0, 1, 1, 1},
            {0, 1, 0, 0, 1},
            {1, 1, 0, 0, 1},
            {0, 1, 1, 1, 0}
        };
        int[] res = h.hamCycle(graph);
        if (res.length > 0) {
            System.out.print("Hamiltonian Cycle: ");
            for (int v : res) System.out.print(v + " ");
            System.out.println(res[0]);
        } else {
            System.out.println("No Hamiltonian Cycle exists");
        }
    }
}

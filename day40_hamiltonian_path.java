public class day40_hamiltonian_path {
    static final int V = 5;

    boolean isSafe(int v, int path[], int pos, int graph[][]) {
        if (graph[path[pos - 1]][v] == 0)
            return false;
        for (int i = 0; i < pos; i++)
            if (path[i] == v)
                return false;
        return true;
    }

    boolean hamCycleUtil(int graph[][], int path[], int pos) {
        if (pos == V) {
            return graph[path[pos - 1]][path[0]] == 1;
        }
        for (int v = 1; v < V; v++) {
            if (isSafe(v, path, pos, graph)) {
                path[pos] = v;
                if (hamCycleUtil(graph, path, pos + 1))
                    return true;
                path[pos] = -1;
            }
        }
        return false;
    }

    int[] hamCycle(int graph[][]) {
        int[] path = new int[V];
        for (int i = 0; i < V; i++)
            path[i] = -1;
        path[0] = 0;

        if (!hamCycleUtil(graph, path, 1)) {
            System.out.println("No Hamiltonian Cycle exists");
            return null;
        }
        return path;
    }

    public static void main(String[] args) {
        day40_hamiltonian_path h = new day40_hamiltonian_path();
        int graph[][] = {
            {0, 1, 0, 1, 0},
            {1, 0, 1, 1, 1},
            {0, 1, 0, 0, 1},
            {1, 1, 0, 0, 1},
            {0, 1, 1, 1, 0}
        };
        int[] result = h.hamCycle(graph);
        if (result != null) {
            for (int v : result) System.out.print(v + " ");
            System.out.println(result[0]);
        }
    }
}

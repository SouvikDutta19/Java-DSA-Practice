import java.util.*;
// Check and print Eulerian trail/circuit for undirected graph using Hierholzer
public class day117_eulerian_path_undirected {
    int N;
    List<Map<Integer,Integer>> adj;

    public day117_eulerian_path_undirected(int n) {
        N = n;
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new HashMap<>());
    }

    void addEdge(int u, int v) {
        adj.get(u).put(v, adj.get(u).getOrDefault(v,0)+1);
        adj.get(v).put(u, adj.get(v).getOrDefault(u,0)+1);
    }

    int findStart() {
        int odd = 0, start = 0;
        for (int i = 0; i < N; i++) {
            int deg = adj.get(i).values().stream().mapToInt(Integer::intValue).sum();
            if (deg % 2 == 1) { odd++; start = i; }
            if (deg > 0 && start == 0) start = i;
        }
        if (odd == 0 || odd == 2) return start;
        return -1;
    }

    List<Integer> hierholzer(int start) {
        if (start == -1) return Collections.emptyList();
        Stack<Integer> st = new Stack<>();
        List<Integer> path = new ArrayList<>();
        st.push(start);
        while (!st.isEmpty()) {
            int v = st.peek();
            if (adj.get(v).isEmpty()) {
                path.add(v);
                st.pop();
            } else {
                int u = adj.get(v).keySet().iterator().next();
                // remove edge v-u
                decrementEdge(v,u);
                st.push(u);
            }
        }
        return path;
    }

    void decrementEdge(int u, int v) {
        adj.get(u).put(v, adj.get(u).get(v)-1);
        if (adj.get(u).get(v) == 0) adj.get(u).remove(v);
        adj.get(v).put(u, adj.get(v).get(u)-1);
        if (adj.get(v).get(u) == 0) adj.get(v).remove(u);
    }

    public static void main(String[] args) {
        day117_eulerian_path_undirected g = new day117_eulerian_path_undirected(5);
        g.addEdge(0,1); g.addEdge(1,2); g.addEdge(2,0); g.addEdge(1,3); g.addEdge(3,4); g.addEdge(4,1);
        int start = g.findStart();
        List<Integer> path = g.hierholzer(start);
        if (path.isEmpty()) System.out.println("No Eulerian trail/circuit exists");
        else System.out.println("Eulerian path/circuit: " + path);
    }
}

import java.util.*;
// Hopcroft-Karp for maximum bipartite matching (0-indexed)
public class day117_hopcroft_karp {
    int nLeft, nRight;
    List<Integer>[] adj;
    int[] pairU, pairV, dist;
    final int INF = 1_000_000_000;

    @SuppressWarnings("unchecked")
    public day117_hopcroft_karp(int nLeft, int nRight) {
        this.nLeft = nLeft; this.nRight = nRight;
        adj = new List[nLeft];
        for (int i = 0; i < nLeft; i++) adj[i] = new ArrayList<>();
        pairU = new int[nLeft];
        pairV = new int[nRight];
        dist = new int[nLeft];
        Arrays.fill(pairU, -1);
        Arrays.fill(pairV, -1);
    }

    void addEdge(int u, int v) { adj[u].add(v); }

    boolean bfs() {
        Queue<Integer> q = new LinkedList<>();
        for (int u = 0; u < nLeft; u++) {
            if (pairU[u] == -1) { dist[u] = 0; q.add(u); }
            else dist[u] = INF;
        }
        boolean reachableFree = false;
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : adj[u]) {
                if (pairV[v] != -1 && dist[pairV[v]] == INF) {
                    dist[pairV[v]] = dist[u] + 1;
                    q.add(pairV[v]);
                }
                if (pairV[v] == -1) reachableFree = true;
            }
        }
        return reachableFree;
    }

    boolean dfs(int u) {
        for (int v : adj[u]) {
            if (pairV[v] == -1 || (dist[pairV[v]] == dist[u] + 1 && dfs(pairV[v]))) {
                pairU[u] = v; pairV[v] = u; return true;
            }
        }
        dist[u] = INF;
        return false;
    }

    int maxMatching() {
        int result = 0;
        while (bfs()) {
            for (int u = 0; u < nLeft; u++)
                if (pairU[u] == -1 && dfs(u)) result++;
        }
        return result;
    }

    public static void main(String[] args) {
        day117_hopcroft_karp hk = new day117_hopcroft_karp(4,4);
        hk.addEdge(0,0); hk.addEdge(0,1);
        hk.addEdge(1,1); hk.addEdge(1,2);
        hk.addEdge(2,2); hk.addEdge(3,2); hk.addEdge(3,3);
        System.out.println("Maximum matching = " + hk.maxMatching());
    }
}

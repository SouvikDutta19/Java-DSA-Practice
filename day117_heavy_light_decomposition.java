import java.util.*;
// Heavy-Light Decomposition (HLD) - supports path queries (sum) on tree using segment tree
public class day117_heavy_light_decomposition {
    int N;
    List<Integer>[] g;
    int[] parent, depth, heavy, head, pos, size;
    int curPos;
    int[] base; // values on nodes according to position
    int[] seg;

    @SuppressWarnings("unchecked")
    public day117_heavy_light_decomposition(int n, int[] vals) {
        N = n;
        g = new List[N];
        for (int i = 0; i < N; i++) g[i] = new ArrayList<>();
        parent = new int[N]; depth = new int[N]; heavy = new int[N];
        head = new int[N]; pos = new int[N]; size = new int[N];
        Arrays.fill(heavy, -1);
        base = new int[N];
        System.arraycopy(vals, 0, base, 0, Math.min(vals.length, N));
    }

    void addEdge(int u, int v) { g[u].add(v); g[v].add(u); }

    int dfs(int v, int p) {
        parent[v] = p; size[v] = 1; int maxSize = 0;
        for (int c : g[v]) if (c != p) {
            depth[c] = depth[v] + 1;
            int csize = dfs(c, v);
            size[v] += csize;
            if (csize > maxSize) { maxSize = csize; heavy[v] = c; }
        }
        return size[v];
    }

    void decompose(int v, int h) {
        head[v] = h; pos[v] = curPos++;
        if (heavy[v] != -1) decompose(heavy[v], h);
        for (int c : g[v]) if (c != parent[v] && c != heavy[v]) decompose(c, c);
    }

    void build() {
        curPos = 0;
        dfs(0, -1);
        decompose(0,0);
        // build segment tree over values mapped by pos[]
        seg = new int[4*N];
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[pos[i]] = base[i];
        buildSeg(arr, 1, 0, N-1);
    }

    void buildSeg(int[] arr, int idx, int l, int r) {
        if (l == r) { seg[idx] = arr[l]; return; }
        int mid = (l+r)/2;
        buildSeg(arr, idx*2, l, mid);
        buildSeg(arr, idx*2+1, mid+1, r);
        seg[idx] = seg[idx*2] + seg[idx*2+1];
    }

    int querySeg(int idx, int l, int r, int ql, int qr) {
        if (ql > r || qr < l) return 0;
        if (ql <= l && r <= qr) return seg[idx];
        int mid = (l+r)/2;
        return querySeg(idx*2, l, mid, ql, qr) + querySeg(idx*2+1, mid+1, r, ql, qr);
    }

    void updateSeg(int idx, int l, int r, int pos, int val) {
        if (l == r) { seg[idx] = val; return; }
        int mid = (l+r)/2;
        if (pos <= mid) updateSeg(idx*2, l, mid, pos, val);
        else updateSeg(idx*2+1, mid+1, r, pos, val);
        seg[idx] = seg[idx*2] + seg[idx*2+1];
    }

    int queryPath(int a, int b) {
        int res = 0;
        while (head[a] != head[b]) {
            if (depth[head[a]] < depth[head[b]]) { int t = a; a = b; b = t; }
            res += querySeg(1, 0, N-1, pos[head[a]], pos[a]);
            a = parent[head[a]];
        }
        if (depth[a] > depth[b]) { int t = a; a = b; b = t; }
        // now a is lca
        res += querySeg(1, 0, N-1, pos[a], pos[b]);
        return res;
    }

    void updateNode(int v, int val) {
        updateSeg(1, 0, N-1, pos[v], val);
    }

    public static void main(String[] args) {
        int n = 9;
        int[] vals = {1,2,3,4,5,6,7,8,9};
        day117_heavy_light_decomposition hld = new day117_heavy_light_decomposition(n, vals);
        hld.addEdge(0,1); hld.addEdge(0,2); hld.addEdge(1,3); hld.addEdge(1,4);
        hld.addEdge(2,5); hld.addEdge(2,6); hld.addEdge(4,7); hld.addEdge(4,8);
        hld.build();
        System.out.println("Query path 3-8 sum: " + hld.queryPath(3,8)); // sum along path
        hld.updateNode(4, 100); // update node 4 value to 100
        System.out.println("After update, query 3-8 sum: " + hld.queryPath(3,8));
    }
}

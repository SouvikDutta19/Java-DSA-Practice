import java.util.*;

public class day21_HeavyLightDecomposition {
    static class SegmentTree {
        int[] tree, arr;
        int n;

        SegmentTree(int[] input) {
            n = input.length;
            arr = input.clone();
            tree = new int[4 * n];
            build(0, 0, n - 1);
        }

        void build(int node, int start, int end) {
            if (start == end) {
                tree[node] = arr[start];
            } else {
                int mid = (start + end) / 2;
                build(2 * node + 1, start, mid);
                build(2 * node + 2, mid + 1, end);
                tree[node] = Math.max(tree[2 * node + 1], tree[2 * node + 2]);
            }
        }

        int query(int node, int start, int end, int l, int r) {
            if (r < start || end < l)
                return Integer.MIN_VALUE;
            if (l <= start && end <= r)
                return tree[node];
            int mid = (start + end) / 2;
            return Math.max(
                query(2 * node + 1, start, mid, l, r),
                query(2 * node + 2, mid + 1, end, l, r)
            );
        }

        int query(int l, int r) {
            return query(0, 0, n - 1, l, r);
        }
    }

    static class HLD {
        List<Integer>[] tree;
        int[] parent, depth, heavy, head, pos, size, values;
        int curPos;
        SegmentTree st;

        HLD(int n, int[] val) {
            tree = new List[n];
            for (int i = 0; i < n; i++) tree[i] = new ArrayList<>();
            parent = new int[n];
            depth = new int[n];
            heavy = new int[n];
            Arrays.fill(heavy, -1);
            head = new int[n];
            pos = new int[n];
            size = new int[n];
            values = val;
        }

        void addEdge(int u, int v) {
            tree[u].add(v);
            tree[v].add(u);
        }

        int dfs(int v, int p) {
            parent[v] = p;
            size[v] = 1;
            int maxSubtree = 0;
            for (int u : tree[v]) {
                if (u != p) {
                    depth[u] = depth[v] + 1;
                    int subtreeSize = dfs(u, v);
                    size[v] += subtreeSize;
                    if (subtreeSize > maxSubtree) {
                        maxSubtree = subtreeSize;
                        heavy[v] = u;
                    }
                }
            }
            return size[v];
        }

        void decompose(int v, int h) {
            head[v] = h;
            pos[v] = curPos++;
            if (heavy[v] != -1)
                decompose(heavy[v], h);
            for (int u : tree[v]) {
                if (u != parent[v] && u != heavy[v])
                    decompose(u, u);
            }
        }

        void build(int root) {
            dfs(root, -1);
            decompose(root, root);

            int[] arr = new int[values.length];
            for (int i = 0; i < values.length; i++) {
                arr[pos[i]] = values[i];
            }
            st = new SegmentTree(arr);
        }

        int query(int u, int v) {
            int res = Integer.MIN_VALUE;
            while (head[u] != head[v]) {
                if (depth[head[u]] < depth[head[v]]) {
                    int temp = u;
                    u = v;
                    v = temp;
                }
                res = Math.max(res, st.query(pos[head[u]], pos[u]));
                u = parent[head[u]];
            }
            if (depth[u] > depth[v]) {
                int temp = u;
                u = v;
                v = temp;
            }
            return Math.max(res, st.query(pos[u], pos[v]));
        }
    }

    public static void main(String[] args) {
        int n = 7;
        int[] values = {1, 2, 3, 4, 5, 6, 7};

        HLD hld = new HLD(n, values);
        hld.addEdge(0, 1);
        hld.addEdge(0, 2);
        hld.addEdge(1, 3);
        hld.addEdge(1, 4);
        hld.addEdge(2, 5);
        hld.addEdge(2, 6);

        hld.build(0);

        System.out.println("Max value from node 3 to 5: " + hld.query(3, 5));
        System.out.println("Max value from node 4 to 6: " + hld.query(4, 6));
    }
}

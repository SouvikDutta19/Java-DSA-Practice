public class day21_segmenttreelazypropagation {
    static class SegmentTree {
        int[] tree, lazy;
        int size;

        SegmentTree(int n) {
            size = n;
            tree = new int[4 * n];
            lazy = new int[4 * n];
        }

        void updateRange(int node, int start, int end, int l, int r, int val) {
            if (lazy[node] != 0) {
                tree[node] += (end - start + 1) * lazy[node];
                if (start != end) {
                    lazy[node * 2] += lazy[node];
                    lazy[node * 2 + 1] += lazy[node];
                }
                lazy[node] = 0;
            }

            if (start > end || start > r || end < l)
                return;

            if (start >= l && end <= r) {
                tree[node] += (end - start + 1) * val;
                if (start != end) {
                    lazy[node * 2] += val;
                    lazy[node * 2 + 1] += val;
                }
                return;
            }

            int mid = (start + end) / 2;
            updateRange(node * 2, start, mid, l, r, val);
            updateRange(node * 2 + 1, mid + 1, end, l, r, val);
            tree[node] = tree[node * 2] + tree[node * 2 + 1];
        }

        int queryRange(int node, int start, int end, int l, int r) {
            if (lazy[node] != 0) {
                tree[node] += (end - start + 1) * lazy[node];
                if (start != end) {
                    lazy[node * 2] += lazy[node];
                    lazy[node * 2 + 1] += lazy[node];
                }
                lazy[node] = 0;
            }

            if (start > end || start > r || end < l)
                return 0;

            if (start >= l && end <= r)
                return tree[node];

            int mid = (start + end) / 2;
            return queryRange(node * 2, start, mid, l, r) +
                   queryRange(node * 2 + 1, mid + 1, end, l, r);
        }

        void build(int[] arr, int node, int start, int end) {
            if (start == end) {
                tree[node] = arr[start];
            } else {
                int mid = (start + end) / 2;
                build(arr, node * 2, start, mid);
                build(arr, node * 2 + 1, mid + 1, end);
                tree[node] = tree[node * 2] + tree[node * 2 + 1];
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        int n = arr.length;
        SegmentTree st = new SegmentTree(n);
        st.build(arr, 1, 0, n - 1);

        System.out.println("Initial sum of [1,3]: " + st.queryRange(1, 0, n - 1, 1, 3));
        st.updateRange(1, 0, n - 1, 1, 5, 10);
        System.out.println("After update, sum of [1,3]: " + st.queryRange(1, 0, n - 1, 1, 3));
    }
}

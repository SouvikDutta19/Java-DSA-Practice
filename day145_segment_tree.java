public class day145_segment_tree {

    static class SegmentTree {
        int[] tree;
        int n;

        SegmentTree(int[] arr) {
            n = arr.length;
            tree = new int[4 * n];
            build(arr, 0, 0, n - 1);
        }

        void build(int[] arr, int idx, int l, int r) {
            if (l == r) {
                tree[idx] = arr[l];
                return;
            }
            int mid = (l + r) / 2;
            build(arr, 2 * idx + 1, l, mid);
            build(arr, 2 * idx + 2, mid + 1, r);
            tree[idx] = tree[2 * idx + 1] + tree[2 * idx + 2];
        }

        void update(int i, int val) {
            updateUtil(0, 0, n - 1, i, val);
        }

        void updateUtil(int idx, int l, int r, int i, int val) {
            if (l == r) {
                tree[idx] = val;
                return;
            }

            int mid = (l + r) / 2;
            if (i <= mid)
                updateUtil(2 * idx + 1, l, mid, i, val);
            else
                updateUtil(2 * idx + 2, mid + 1, r, i, val);

            tree[idx] = tree[2 * idx + 1] + tree[2 * idx + 2];
        }

        int query(int ql, int qr) {
            return queryUtil(0, 0, n - 1, ql, qr);
        }

        int queryUtil(int idx, int l, int r, int ql, int qr) {
            if (qr < l || ql > r) return 0;
            if (ql <= l && r <= qr) return tree[idx];

            int mid = (l + r) / 2;
            return queryUtil(2 * idx + 1, l, mid, ql, qr) +
                   queryUtil(2 * idx + 2, mid + 1, r, ql, qr);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,7,9,11};
        SegmentTree st = new SegmentTree(arr);

        System.out.println(st.query(1,3));
        st.update(1,10);
        System.out.println(st.query(1,3));
    }
}

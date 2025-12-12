// Day162 - Segment Tree (point update, range sum query)
public class day162_segment_tree_point_update_range_sum {
    static class SegTree {
        int n;
        int[] tree;
        SegTree(int[] a) {
            n = a.length;
            tree = new int[4 * n];
            build(1, 0, n - 1, a);
        }
        void build(int node, int l, int r, int[] a) {
            if (l == r) { tree[node] = a[l]; return; }
            int mid = (l + r) >> 1;
            build(node<<1, l, mid, a);
            build(node<<1|1, mid+1, r, a);
            tree[node] = tree[node<<1] + tree[node<<1|1];
        }
        void update(int idx, int val) { update(1,0,n-1,idx,val); }
        void update(int node, int l, int r, int idx, int val) {
            if (l == r) { tree[node] = val; return; }
            int mid = (l + r) >> 1;
            if (idx <= mid) update(node<<1, l, mid, idx, val);
            else update(node<<1|1, mid+1, r, idx, val);
            tree[node] = tree[node<<1] + tree[node<<1|1];
        }
        int query(int L, int R) { return query(1,0,n-1,L,R); }
        int query(int node, int l, int r, int L, int R) {
            if (R < l || r < L) return 0;
            if (L <= l && r <= R) return tree[node];
            int mid = (l + r) >> 1;
            return query(node<<1,l,mid,L,R) + query(node<<1|1,mid+1,r,L,R);
        }
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6};
        SegTree st = new SegTree(a);
        System.out.println("Sum(1..4) = " + st.query(1,4)); // 2+3+4+5 = 14
        st.update(2, 10); // a[2]=10
        System.out.println("After update Sum(1..4) = " + st.query(1,4)); // 2+10+4+5 = 21
    }
}
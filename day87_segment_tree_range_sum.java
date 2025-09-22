class SegmentTree {
    int[] tree, arr;
    int n;

    SegmentTree(int[] arr) {
        this.arr = arr;
        this.n = arr.length;
        tree = new int[4*n];
        build(1, 0, n-1);
    }

    void build(int node, int l, int r) {
        if (l == r) {
            tree[node] = arr[l];
            return;
        }
        int mid = (l+r)/2;
        build(node*2, l, mid);
        build(node*2+1, mid+1, r);
        tree[node] = tree[node*2] + tree[node*2+1];
    }

    void update(int node, int l, int r, int idx, int val) {
        if (l == r) {
            tree[node] = val;
            return;
        }
        int mid = (l+r)/2;
        if (idx <= mid) update(node*2, l, mid, idx, val);
        else update(node*2+1, mid+1, r, idx, val);
        tree[node] = tree[node*2] + tree[node*2+1];
    }

    int query(int node, int l, int r, int ql, int qr) {
        if (ql > r || qr < l) return 0;
        if (ql <= l && r <= qr) return tree[node];
        int mid = (l+r)/2;
        return query(node*2, l, mid, ql, qr) + query(node*2+1, mid+1, r, ql, qr);
    }
}

public class day87_segment_tree_range_sum {
    public static void main(String[] args) {
        int[] arr = {1,3,5,7,9,11};
        SegmentTree st = new SegmentTree(arr);
        System.out.println(st.query(1,0,arr.length-1,1,3));
        st.update(1,0,arr.length-1,1,10);
        System.out.println(st.query(1,0,arr.length-1,1,3));
    }
}

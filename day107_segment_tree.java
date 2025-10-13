import java.util.*;

// Segment Tree Implementation for Range Sum Query
public class day107_segment_tree {
    int[] tree;
    int n;

    public day107_segment_tree(int[] arr) {
        n = arr.length;
        tree = new int[4 * n];
        build(arr, 1, 0, n - 1);
    }

    void build(int[] arr, int node, int start, int end) {
        if (start == end) tree[node] = arr[start];
        else {
            int mid = (start + end) / 2;
            build(arr, 2 * node, start, mid);
            build(arr, 2 * node + 1, mid + 1, end);
            tree[node] = tree[2 * node] + tree[2 * node + 1];
        }
    }

    void update(int node, int start, int end, int idx, int val) {
        if (start == end) tree[node] = val;
        else {
            int mid = (start + end) / 2;
            if (idx <= mid) update(2 * node, start, mid, idx, val);
            else update(2 * node + 1, mid + 1, end, idx, val);
            tree[node] = tree[2 * node] + tree[2 * node + 1];
        }
    }

    int query(int node, int start, int end, int l, int r) {
        if (r < start || end < l) return 0;
        if (l <= start && end <= r) return tree[node];
        int mid = (start + end) / 2;
        return query(2 * node, start, mid, l, r) +
               query(2 * node + 1, mid + 1, end, l, r);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        day107_segment_tree st = new day107_segment_tree(arr);
        System.out.println("Sum [1,3]: " + st.query(1, 0, arr.length - 1, 1, 3));
        st.update(1, 0, arr.length - 1, 1, 10);
        System.out.println("After update, Sum [1,3]: " + st.query(1, 0, arr.length - 1, 1, 3));
    }
}

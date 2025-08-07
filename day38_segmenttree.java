public class day38_segmenttree {
    int[] tree, arr;
    int n;

    public day38_segmenttree(int[] input) {
        n = input.length;
        arr = input;
        tree = new int[4 * n];
        build(0, 0, n - 1);
    }

    void build(int node, int start, int end) {
        if (start == end) tree[node] = arr[start];
        else {
            int mid = (start + end) / 2;
            build(2 * node + 1, start, mid);
            build(2 * node + 2, mid + 1, end);
            tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
        }
    }

    int query(int node, int start, int end, int l, int r) {
        if (r < start || end < l) return 0;
        if (l <= start && end <= r) return tree[node];
        int mid = (start + end) / 2;
        return query(2 * node + 1, start, mid, l, r) +
               query(2 * node + 2, mid + 1, end, l, r);
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 3, 4};
        day38_segmenttree st = new day38_segmenttree(arr);
        System.out.println("Sum of range [1,3]: " + st.query(0, 0, arr.length - 1, 1, 3));
    }
}

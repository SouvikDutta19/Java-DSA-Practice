class SegmentTree {
    int tree[];

    SegmentTree(int arr[], int n) {
        tree = new int[4 * n];
        buildTree(arr, 0, n - 1, 1);
    }

    void buildTree(int arr[], int start, int end, int index) {
        if (start == end) {
            tree[index] = arr[start];
            return;
        }

        int mid = (start + end) / 2;
        buildTree(arr, start, mid, 2 * index);
        buildTree(arr, mid + 1, end, 2 * index + 1);
        tree[index] = tree[2 * index] + tree[2 * index + 1];
    }

    void update(int start, int end, int index, int pos, int val) {
        if (start == end) {
            tree[index] = val;
            return;
        }

        int mid = (start + end) / 2;

        if (pos <= mid)
            update(start, mid, 2 * index, pos, val);
        else
            update(mid + 1, end, 2 * index + 1, pos, val);

        tree[index] = tree[2 * index] + tree[2 * index + 1];
    }

    int query(int start, int end, int index, int l, int r) {
        if (r < start || end < l)
            return 0;

        if (l <= start && end <= r)
            return tree[index];

        int mid = (start + end) / 2;
        return query(start, mid, 2 * index, l, r)
                + query(mid + 1, end, 2 * index + 1, l, r);
    }
}

public class day156_segment_tree_range_sum {
    public static void main(String[] args) {
        int arr[] = {1, 3, 5, 7, 9, 11};
        int n = arr.length;

        SegmentTree st = new SegmentTree(arr, n);

        System.out.println("Sum (1 to 3): " + st.query(0, n - 1, 1, 1, 3));

        st.update(0, n - 1, 1, 1, 10);

        System.out.println("After update, Sum (1 to 3): " + st.query(0, n - 1, 1, 1, 3));
    }
}
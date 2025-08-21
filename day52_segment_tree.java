public class day52_segment_tree {
    int[] segTree;
    int n;

    public day52_segment_tree(int[] arr) {
        n = arr.length;
        segTree = new int[4 * n];
        build(arr, 0, n - 1, 0);
    }

    private void build(int[] arr, int start, int end, int index) {
        if (start == end) {
            segTree[index] = arr[start];
            return;
        }
        int mid = (start + end) / 2;
        build(arr, start, mid, 2 * index + 1);
        build(arr, mid + 1, end, 2 * index + 2);
        segTree[index] = segTree[2 * index + 1] + segTree[2 * index + 2];
    }

    public int query(int l, int r, int start, int end, int index) {
        if (r < start || l > end) return 0;
        if (l <= start && r >= end) return segTree[index];
        int mid = (start + end) / 2;
        return query(l, r, start, mid, 2 * index + 1) +
               query(l, r, mid + 1, end, 2 * index + 2);
    }

    public void update(int pos, int newVal, int start, int end, int index) {
        if (start == end) {
            segTree[index] = newVal;
            return;
        }
        int mid = (start + end) / 2;
        if (pos <= mid) update(pos, newVal, start, mid, 2 * index + 1);
        else update(pos, newVal, mid + 1, end, 2 * index + 2);

        segTree[index] = segTree[2 * index + 1] + segTree[2 * index + 2];
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        day52_segment_tree st = new day52_segment_tree(arr);

        System.out.println("Sum query (1,3): " + st.query(1, 3, 0, arr.length - 1, 0));
        st.update(1, 10, 0, arr.length - 1, 0);
        System.out.println("After update, Sum query (1,3): " + st.query(1, 3, 0, arr.length - 1, 0));
    }
}

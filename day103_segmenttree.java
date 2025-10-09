public class day103_segmenttree {
    int[] segmentTree;
    int n;

    public day103_segmenttree(int[] arr) {
        n = arr.length;
        segmentTree = new int[4 * n];
        build(arr, 0, 0, n - 1);
    }

    private void build(int[] arr, int index, int low, int high) {
        if (low == high) {
            segmentTree[index] = arr[low];
            return;
        }
        int mid = (low + high) / 2;
        build(arr, 2 * index + 1, low, mid);
        build(arr, 2 * index + 2, mid + 1, high);
        segmentTree[index] = segmentTree[2 * index + 1] + segmentTree[2 * index + 2];
    }

    public void update(int pos, int val) {
        updateUtil(0, 0, n - 1, pos, val);
    }

    private void updateUtil(int index, int low, int high, int pos, int val) {
        if (low == high) {
            segmentTree[index] = val;
            return;
        }
        int mid = (low + high) / 2;
        if (pos <= mid)
            updateUtil(2 * index + 1, low, mid, pos, val);
        else
            updateUtil(2 * index + 2, mid + 1, high, pos, val);
        segmentTree[index] = segmentTree[2 * index + 1] + segmentTree[2 * index + 2];
    }

    public int query(int left, int right) {
        return queryUtil(0, 0, n - 1, left, right);
    }

    private int queryUtil(int index, int low, int high, int left, int right) {
        if (left > high || right < low) return 0;
        if (left <= low && high <= right) return segmentTree[index];
        int mid = (low + high) / 2;
        return queryUtil(2 * index + 1, low, mid, left, right) +
               queryUtil(2 * index + 2, mid + 1, high, left, right);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        day103_segmenttree st = new day103_segmenttree(arr);

        System.out.println("Sum of values in range(1,3): " + st.query(1, 3));
        st.update(1, 10);
        System.out.println("Updated sum of values in range(1,3): " + st.query(1, 3));
    }
}

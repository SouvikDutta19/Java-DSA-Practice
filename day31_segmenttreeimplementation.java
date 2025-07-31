public class day31_segmenttreeimplementation {
    int[] segTree;
    int[] arr;

    public day31_segmenttreeimplementation(int[] input) {
        int n = input.length;
        arr = input.clone();
        segTree = new int[4 * n];
        build(0, 0, n - 1);
    }

    private void build(int node, int start, int end) {
        if (start == end) {
            segTree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;
            build(2 * node + 1, start, mid);
            build(2 * node + 2, mid + 1, end);
            segTree[node] = segTree[2 * node + 1] + segTree[2 * node + 2];
        }
    }

    public int query(int l, int r) {
        return queryUtil(0, 0, arr.length - 1, l, r);
    }

    private int queryUtil(int node, int start, int end, int l, int r) {
        if (r < start || end < l) return 0;
        if (l <= start && end <= r) return segTree[node];
        int mid = (start + end) / 2;
        return queryUtil(2 * node + 1, start, mid, l, r) +
               queryUtil(2 * node + 2, mid + 1, end, l, r);
    }

    public void update(int idx, int val) {
        updateUtil(0, 0, arr.length - 1, idx, val);
    }

    private void updateUtil(int node, int start, int end, int idx, int val) {
        if (start == end) {
            arr[idx] = val;
            segTree[node] = val;
        } else {
            int mid = (start + end) / 2;
            if (idx <= mid) updateUtil(2 * node + 1, start, mid, idx, val);
            else updateUtil(2 * node + 2, mid + 1, end, idx, val);
            segTree[node] = segTree[2 * node + 1] + segTree[2 * node + 2];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        day31_segmenttreeimplementation segTree = new day31_segmenttreeimplementation(arr);
        System.out.println("Sum(1, 3): " + segTree.query(1, 3)); // 15
        segTree.update(1, 10);
        System.out.println("Sum(1, 3) after update: " + segTree.query(1, 3)); // 22
    }
}

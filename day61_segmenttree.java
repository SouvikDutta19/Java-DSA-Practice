// Program to implement Segment Tree for Range Sum Queries
import java.util.*;

public class day61_segmenttree {
    static int[] segTree;

    public static void buildTree(int[] arr, int n) {
        segTree = new int[4 * n];
        build(arr, 0, n - 1, 0);
    }

    private static void build(int[] arr, int l, int r, int idx) {
        if (l == r) {
            segTree[idx] = arr[l];
            return;
        }
        int mid = (l + r) / 2;
        build(arr, l, mid, 2 * idx + 1);
        build(arr, mid + 1, r, 2 * idx + 2);
        segTree[idx] = segTree[2 * idx + 1] + segTree[2 * idx + 2];
    }

    public static int query(int ql, int qr, int l, int r, int idx) {
        if (ql <= l && qr >= r) return segTree[idx];
        if (qr < l || ql > r) return 0;
        int mid = (l + r) / 2;
        return query(ql, qr, l, mid, 2 * idx + 1) + query(ql, qr, mid + 1, r, 2 * idx + 2);
    }

    public static void update(int pos, int newVal, int l, int r, int idx) {
        if (l == r) {
            segTree[idx] = newVal;
            return;
        }
        int mid = (l + r) / 2;
        if (pos <= mid) update(pos, newVal, l, mid, 2 * idx + 1);
        else update(pos, newVal, mid + 1, r, 2 * idx + 2);
        segTree[idx] = segTree[2 * idx + 1] + segTree[2 * idx + 2];
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        int n = arr.length;
        buildTree(arr, n);

        System.out.println("Sum of values in range(1,3): " + query(1, 3, 0, n - 1, 0));

        update(1, 10, 0, n - 1, 0);
        System.out.println("Updated sum of values in range(1,3): " + query(1, 3, 0, n - 1, 0));
    }
}

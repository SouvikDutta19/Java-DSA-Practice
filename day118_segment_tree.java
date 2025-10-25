import java.util.*;

public class day118_segment_tree {
    static int[] segTree;

    public static void buildTree(int[] arr, int start, int end, int index) {
        if (start == end) {
            segTree[index] = arr[start];
            return;
        }
        int mid = (start + end) / 2;
        buildTree(arr, start, mid, 2 * index + 1);
        buildTree(arr, mid + 1, end, 2 * index + 2);
        segTree[index] = segTree[2 * index + 1] + segTree[2 * index + 2];
    }

    public static int query(int qs, int qe, int ss, int se, int index) {
        if (qs <= ss && qe >= se) return segTree[index];
        if (qe < ss || qs > se) return 0;
        int mid = (ss + se) / 2;
        return query(qs, qe, ss, mid, 2 * index + 1) + query(qs, qe, mid + 1, se, 2 * index + 2);
    }

    public static void update(int ss, int se, int i, int diff, int index) {
        if (i < ss || i > se) return;
        segTree[index] += diff;
        if (ss != se) {
            int mid = (ss + se) / 2;
            update(ss, mid, i, diff, 2 * index + 1);
            update(mid + 1, se, i, diff, 2 * index + 2);
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 7, 8, 9};
        int n = arr.length;
        segTree = new int[4 * n];
        buildTree(arr, 0, n - 1, 0);
        System.out.println("Sum of range [1, 4]: " + query(1, 4, 0, n - 1, 0));
        update(0, n - 1, 2, 3, 0);
        System.out.println("After update, sum of range [1, 4]: " + query(1, 4, 0, n - 1, 0));
    }
}

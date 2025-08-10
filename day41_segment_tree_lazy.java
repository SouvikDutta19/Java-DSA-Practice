import java.util.*;

public class day41_segment_tree_lazy {
    static int[] seg, lazy;
    static int n;

    static void build(int[] arr, int idx, int l, int r) {
        if (l == r) {
            seg[idx] = arr[l];
            return;
        }
        int mid = (l + r) / 2;
        build(arr, 2 * idx, l, mid);
        build(arr, 2 * idx + 1, mid + 1, r);
        seg[idx] = seg[2 * idx] + seg[2 * idx + 1];
    }

    static void updateRange(int idx, int l, int r, int ql, int qr, int val) {
        if (lazy[idx] != 0) {
            seg[idx] += (r - l + 1) * lazy[idx];
            if (l != r) {
                lazy[2 * idx] += lazy[idx];
                lazy[2 * idx + 1] += lazy[idx];
            }
            lazy[idx] = 0;
        }
        if (l > r || l > qr || r < ql) return;

        if (l >= ql && r <= qr) {
            seg[idx] += (r - l + 1) * val;
            if (l != r) {
                lazy[2 * idx] += val;
                lazy[2 * idx + 1] += val;
            }
            return;
        }

        int mid = (l + r) / 2;
        updateRange(2 * idx, l, mid, ql, qr, val);
        updateRange(2 * idx + 1, mid + 1, r, ql, qr, val);
        seg[idx] = seg[2 * idx] + seg[2 * idx + 1];
    }

    static int query(int idx, int l, int r, int ql, int qr) {
        if (l > r || l > qr || r < ql) return 0;
        if (lazy[idx] != 0) {
            seg[idx] += (r - l + 1) * lazy[idx];
            if (l != r) {
                lazy[2 * idx] += lazy[idx];
                lazy[2 * idx + 1] += lazy[idx];
            }
            lazy[idx] = 0;
        }
        if (l >= ql && r <= qr) return seg[idx];

        int mid = (l + r) / 2;
        return query(2 * idx, l, mid, ql, qr) + query(2 * idx + 1, mid + 1, r, ql, qr);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        n = arr.length;
        seg = new int[4 * n];
        lazy = new int[4 * n];
        build(arr, 1, 0, n - 1);

        System.out.println("Initial sum (1-3): " + query(1, 0, n - 1, 1, 3));
        updateRange(1, 0, n - 1, 1, 5, 10);
        System.out.println("Updated sum (1-3): " + query(1, 0, n - 1, 1, 3));
    }
}

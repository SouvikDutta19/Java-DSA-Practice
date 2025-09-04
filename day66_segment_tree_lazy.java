import java.io.*;
import java.util.*;

public class day66_segment_tree_lazy {
    static int[] seg, lazy;
    static int n;

    static void build(int idx, int l, int r, int[] arr) {
        if (l == r) {
            seg[idx] = arr[l];
            return;
        }
        int mid = (l + r) / 2;
        build(2*idx, l, mid, arr);
        build(2*idx+1, mid+1, r, arr);
        seg[idx] = seg[2*idx] + seg[2*idx+1];
    }

    static void update(int idx, int l, int r, int ql, int qr, int val) {
        if (lazy[idx] != 0) {
            seg[idx] += (r-l+1) * lazy[idx];
            if (l != r) {
                lazy[2*idx] += lazy[idx];
                lazy[2*idx+1] += lazy[idx];
            }
            lazy[idx] = 0;
        }
        if (l > r || l > qr || r < ql) return;

        if (l >= ql && r <= qr) {
            seg[idx] += (r-l+1) * val;
            if (l != r) {
                lazy[2*idx] += val;
                lazy[2*idx+1] += val;
            }
            return;
        }

        int mid = (l + r) / 2;
        update(2*idx, l, mid, ql, qr, val);
        update(2*idx+1, mid+1, r, ql, qr, val);
        seg[idx] = seg[2*idx] + seg[2*idx+1];
    }

    static int query(int idx, int l, int r, int ql, int qr) {
        if (lazy[idx] != 0) {
            seg[idx] += (r-l+1) * lazy[idx];
            if (l != r) {
                lazy[2*idx] += lazy[idx];
                lazy[2*idx+1] += lazy[idx];
            }
            lazy[idx] = 0;
        }
        if (l > r || l > qr || r < ql) return 0;

        if (l >= ql && r <= qr) return seg[idx];

        int mid = (l + r) / 2;
        return query(2*idx, l, mid, ql, qr) + query(2*idx+1, mid+1, r, ql, qr);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[] arr = new int[size];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) arr[i] = Integer.parseInt(st.nextToken());
        n = size;
        seg = new int[4*n];
        lazy = new int[4*n];
        build(1, 0, n-1, arr);

        update(1, 0, n-1, 1, 3, 5);
        System.out.println(query(1, 0, n-1, 0, 4));
    }
}

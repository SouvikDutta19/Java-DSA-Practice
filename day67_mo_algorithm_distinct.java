import java.io.*;
import java.util.*;

/**
 * Mo's Algorithm (offline) for counting distinct values in range queries.
 *
 * Input:
 * n
 * a1..an
 * q
 * q lines: l r (1-indexed)
 * Output:
 * distinct count for each query in order
 */
public class day67_mo_algorithm_distinct {
    static class Query {
        int l, r, idx;
        Query(int l, int r, int idx) { this.l = l; this.r = r; this.idx = idx; }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());

        int q = Integer.parseInt(br.readLine().trim());
        Query[] qs = new Query[q];
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken()) - 1;
            int r = Integer.parseInt(st.nextToken()) - 1;
            qs[i] = new Query(l, r, i);
        }

        int B = Math.max(1, (int)Math.sqrt(n));
        Arrays.sort(qs, (x, y) -> {
            int bx = x.l / B, by = y.l / B;
            if (bx != by) return bx - by;
            return (bx % 2 == 0) ? (x.r - y.r) : (y.r - x.r); // Hilbert-like optimization
        });

        int[] freq = new int[1_000_001]; // adjust if needed
        int curL = 0, curR = -1, distinct = 0;
        int[] ans = new int[q];

        for (Query qu : qs) {
            while (curL > qu.l) if (freq[a[--curL]]++ == 0) distinct++;
            while (curR < qu.r) if (freq[a[++curR]]++ == 0) distinct++;
            while (curL < qu.l) if (--freq[a[curL++]] == 0) distinct--;
            while (curR > qu.r) if (--freq[a[curR--]] == 0) distinct--;
            ans[qu.idx] = distinct;
        }

        StringBuilder out = new StringBuilder();
        for (int i = 0; i < q; i++) out.append(ans[i]).append('\n');
        System.out.print(out.toString());
    }
}

import java.util.*;

public class day66_fenwick_tree {
    static class Fenwick {
        int[] bit;
        int n;

        Fenwick(int n) {
            this.n = n;
            bit = new int[n+1];
        }

        void update(int idx, int val) {
            for (; idx <= n; idx += idx & -idx) bit[idx] += val;
        }

        int query(int idx) {
            int sum = 0;
            for (; idx > 0; idx -= idx & -idx) sum += bit[idx];
            return sum;
        }

        int rangeQuery(int l, int r) {
            return query(r) - query(l-1);
        }
    }

    public static void main(String[] args) {
        Fenwick fw = new Fenwick(10);
        fw.update(1, 5);
        fw.update(3, 2);
        fw.update(5, 7);
        System.out.println(fw.rangeQuery(1, 5));
    }
}

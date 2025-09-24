public class day89_binary_indexed_tree {
    int[] BIT;
    int n;

    public day89_binary_indexed_tree(int n) {
        this.n = n + 1;
        BIT = new int[this.n];
    }

    void update(int idx, int val) {
        for (; idx < n; idx += idx & -idx)
            BIT[idx] += val;
    }

    int query(int idx) {
        int sum = 0;
        for (; idx > 0; idx -= idx & -idx)
            sum += BIT[idx];
        return sum;
    }

    public static void main(String[] args) {
        day89_binary_indexed_tree ft = new day89_binary_indexed_tree(10);
        ft.update(2, 5);
        ft.update(4, 3);
        ft.update(5, 7);
        System.out.println("Prefix sum till 5: " + ft.query(5));
    }
}

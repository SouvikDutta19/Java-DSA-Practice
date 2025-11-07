// day131_fenwick_tree.java
// Fenwick Tree (Binary Indexed Tree) for prefix sums

public class day131_fenwick_tree {
    int[] BIT;
    int n;

    public day131_fenwick_tree(int n) {
        this.n = n + 1;
        BIT = new int[this.n];
    }

    void update(int index, int val) {
        index++;
        while (index < n) {
            BIT[index] += val;
            index += index & -index;
        }
    }

    int query(int index) {
        index++;
        int sum = 0;
        while (index > 0) {
            sum += BIT[index];
            index -= index & -index;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        day131_fenwick_tree ft = new day131_fenwick_tree(arr.length);
        for (int i = 0; i < arr.length; i++) ft.update(i, arr[i]);
        System.out.println("Prefix sum up to index 3: " + ft.query(3));
        ft.update(2, 2);
        System.out.println("After update, prefix sum up to index 3: " + ft.query(3));
    }
}

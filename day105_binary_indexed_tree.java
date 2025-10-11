// Binary Indexed Tree (Fenwick Tree) implementation
public class day105_binary_indexed_tree {
    int[] BIT;
    int n;

    public day105_binary_indexed_tree(int n) {
        this.n = n;
        BIT = new int[n + 1];
    }

    void update(int index, int val) {
        while (index <= n) {
            BIT[index] += val;
            index += index & (-index);
        }
    }

    int query(int index) {
        int sum = 0;
        while (index > 0) {
            sum += BIT[index];
            index -= index & (-index);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {0, 3, 2, -1, 6, 5, 4, -3, 3, 7, 2, 3};
        int n = arr.length - 1;
        day105_binary_indexed_tree bit = new day105_binary_indexed_tree(n);
        for (int i = 1; i <= n; i++)
            bit.update(i, arr[i]);
        System.out.println("Sum of first 5 elements: " + bit.query(5));
        bit.update(3, 6);
        System.out.println("Updated sum of first 5 elements: " + bit.query(5));
    }
}

public class day40_binary_indexed_tree {
    static int[] BIT;
    static int n;

    static void update(int index, int val) {
        for (; index <= n; index += index & -index)
            BIT[index] += val;
    }

    static int query(int index) {
        int sum = 0;
        for (; index > 0; index -= index & -index)
            sum += BIT[index];
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        n = arr.length;
        BIT = new int[n + 1];

        for (int i = 0; i < n; i++)
            update(i + 1, arr[i]);

        System.out.println("Sum of first 3 elements: " + query(3));
        update(3, 6);
        System.out.println("Sum after update: " + query(3));
    }
}

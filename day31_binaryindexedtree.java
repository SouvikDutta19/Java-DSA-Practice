public class day31_binaryindexedtree {
    int[] BIT;
    int n;

    public day31_binaryindexedtree(int size) {
        n = size;
        BIT = new int[n + 1];
    }

    void update(int index, int val) {
        for (; index <= n; index += index & -index)
            BIT[index] += val;
    }

    int query(int index) {
        int sum = 0;
        for (; index > 0; index -= index & -index)
            sum += BIT[index];
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {0, 3, 2, -1, 6, 5, 4, -3}; // 1-based indexing
        int n = arr.length - 1;
        day31_binaryindexedtree bit = new day31_binaryindexedtree(n);
        for (int i = 1; i <= n; i++)
            bit.update(i, arr[i]);

        System.out.println("Sum of first 5 elements: " + bit.query(5)); // 15
        bit.update(3, 6);
        System.out.println("Updated sum of first 5 elements: " + bit.query(5)); // 21
    }
}

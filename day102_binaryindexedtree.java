public class day102_binaryindexedtree {
    int[] BIT;
    int n;

    public day102_binaryindexedtree(int[] arr) {
        n = arr.length;
        BIT = new int[n + 1];
        for (int i = 0; i < n; i++) update(i, arr[i]);
    }

    void update(int index, int val) {
        index++;
        while (index <= n) {
            BIT[index] += val;
            index += index & -index;
        }
    }

    int getSum(int index) {
        index++;
        int sum = 0;
        while (index > 0) {
            sum += BIT[index];
            index -= index & -index;
        }
        return sum;
    }

    int rangeSum(int l, int r) {
        return getSum(r) - getSum(l - 1);
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, -1, 6, 5, 4, -3, 3, 7, 2, 3};
        day102_binaryindexedtree bit = new day102_binaryindexedtree(arr);
        System.out.println("Sum of [0,5] = " + bit.rangeSum(0, 5));
        bit.update(3, 6);
        System.out.println("Updated sum of [0,5] = " + bit.rangeSum(0, 5));
    }
}

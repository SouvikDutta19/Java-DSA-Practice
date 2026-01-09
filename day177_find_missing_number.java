public class day177_find_missing_number {

    public static int findMissing(int[] arr, int n) {
        int xor1 = 0, xor2 = 0;

        for (int i = 1; i <= n; i++)
            xor1 ^= i;

        for (int num : arr)
            xor2 ^= num;

        return xor1 ^ xor2;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5};
        System.out.println("Missing Number: " + findMissing(arr, 5));
    }
}
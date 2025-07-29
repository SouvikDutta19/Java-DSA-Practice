public class CountingSortAlgorithm {

    public static void countingSort(int[] arr, int max) {
        int[] count = new int[max + 1];
        int[] output = new int[arr.length];

        for (int i : arr)
            count[i]++;

        for (int i = 1; i <= max; i++)
            count[i] += count[i - 1];

        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        System.arraycopy(output, 0, arr, 0, arr.length);
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 8, 3, 3, 1};
        int max = 8;
        countingSort(arr, max);
        System.out.print("Sorted Array: ");
        for (int x : arr)
            System.out.print(x + " ");
    }
}

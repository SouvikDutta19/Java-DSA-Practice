public class day153_insertionsortdescending {

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] < key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 9, 1, 5};

        insertionSort(arr);

        System.out.print("Sorted (Descending): ");
        for (int n : arr) System.out.print(n + " ");
    }
}
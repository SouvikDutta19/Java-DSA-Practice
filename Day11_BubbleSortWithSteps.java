import java.util.Arrays;

public class Day11_BubbleSortWithSteps {

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        int pass = 1;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            System.out.println("🔄 Pass " + pass++);
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(Arrays.toString(arr) + " -> ");
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
                System.out.println(Arrays.toString(arr));
            }
            if (!swapped) break;
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        bubbleSort(arr);
        System.out.println("✅ Sorted Array: " + Arrays.toString(arr));
    }
}

import java.util.Arrays;

public class Day15_MergeSortImplementation {

    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return;

        int mid = (left + right) / 2;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] result = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            result[k++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
        }

        while (i <= mid) result[k++] = arr[i++];
        while (j <= right) result[k++] = arr[j++];

        for (i = left, k = 0; i <= right; i++, k++) arr[i] = result[k];
    }

    public static void main(String[] args) {
        int[] data = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Before sort: " + Arrays.toString(data));
        mergeSort(data, 0, data.length - 1);
        System.out.println("After sort: " + Arrays.toString(data));
    }
}

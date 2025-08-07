public class day38_countinversions {
    public static int mergeSort(int[] arr, int[] temp, int left, int right) {
        int mid, inv_count = 0;
        if (right > left) {
            mid = (right + left) / 2;
            inv_count += mergeSort(arr, temp, left, mid);
            inv_count += mergeSort(arr, temp, mid + 1, right);
            inv_count += merge(arr, temp, left, mid + 1, right);
        }
        return inv_count;
    }

    public static int merge(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left, j = mid, k = left, inv_count = 0;
        while ((i <= mid - 1) && (j <= right)) {
            if (arr[i] <= arr[j]) temp[k++] = arr[i++];
            else {
                temp[k++] = arr[j++];
                inv_count += (mid - i);
            }
        }
        while (i <= mid - 1) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];
        for (i = left; i <= right; i++) arr[i] = temp[i];
        return inv_count;
    }

    public static void main(String[] args) {
        int[] arr = {1, 20, 6, 4, 5};
        int[] temp = new int[arr.length];
        int invCount = mergeSort(arr, temp, 0, arr.length - 1);
        System.out.println("Number of inversions are " + invCount);
    }
}

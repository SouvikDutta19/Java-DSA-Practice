public class CountInversions {
    public static int mergeSort(int[] arr, int[] temp, int left, int right) {
        int mid, invCount = 0;
        if (right > left) {
            mid = (right + left) / 2;
            invCount += mergeSort(arr, temp, left, mid);
            invCount += mergeSort(arr, temp, mid + 1, right);
            invCount += merge(arr, temp, left, mid + 1, right);
        }
        return invCount;
    }

    public static int merge(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left, j = mid, k = left, invCount = 0;
        while ((i <= mid - 1) && (j <= right)) {
            if (arr[i] <= arr[j])
                temp[k++] = arr[i++];
            else {
                temp[k++] = arr[j++];
                invCount += (mid - i);
            }
        }
        while (i <= mid - 1) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];
        for (i = left; i <= right; i++) arr[i] = temp[i];
        return invCount;
    }

    public static void main(String[] args) {
        int[] arr = {1, 20, 6, 4, 5};
        int[] temp = new int[arr.length];
        int invCount = mergeSort(arr, temp, 0, arr.length - 1);
        System.out.println("Number of inversions are " + invCount);
    }
}

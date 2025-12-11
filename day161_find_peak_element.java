public class day161_find_peak_element {

    public static int findPeak(int arr[]) {
        int n = arr.length;
        int left = 0, right = n - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            boolean leftOK = (mid == 0) || arr[mid] >= arr[mid - 1];
            boolean rightOK = (mid == n - 1) || arr[mid] >= arr[mid + 1];

            if (leftOK && rightOK)
                return mid;

            if (mid > 0 && arr[mid - 1] > arr[mid])
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {1, 3, 20, 4, 1, 0};

        int peak = findPeak(arr);
        System.out.println("Peak element at index: " + peak + ", value: " + arr[peak]);
    }
}
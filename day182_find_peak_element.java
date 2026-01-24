public class day182_find_peak_element {

    public static int findPeak(int[] arr) {
        int low = 0, high = arr.length - 1;

        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] > arr[mid + 1])
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,1,3,5,6,4};
        System.out.println(findPeak(arr));
    }
}
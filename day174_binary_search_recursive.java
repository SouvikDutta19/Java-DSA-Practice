public class day174_binary_search_recursive {

    public static int binarySearch(int[] arr, int left, int right, int target) {
        if (left > right) return -1;
        int mid = (left + right) / 2;

        if (arr[mid] == target) return mid;
        else if (target < arr[mid]) return binarySearch(arr, left, mid - 1, target);
        else return binarySearch(arr, mid + 1, right, target);
    }

    public static void main(String[] args) {
        int[] arr = {2,4,6,8,10,12,14};
        int target = 10;
        int result = binarySearch(arr, 0, arr.length-1, target);

        System.out.println("Element found at index: " + result);
    }
}
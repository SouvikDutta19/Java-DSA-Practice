public class Day13_BinarySearchRecursive {

    public static int binarySearch(int[] arr, int left, int right, int target) {
        if (left > right) return -1;

        int mid = left + (right - left) / 2;
        if (arr[mid] == target) return mid;
        else if (arr[mid] > target) return binarySearch(arr, left, mid - 1, target);
        else return binarySearch(arr, mid + 1, right, target);
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 7, 10, 13, 18, 21, 29};
        int target = 13;
        int result = binarySearch(arr, 0, arr.length - 1, target);
        System.out.println(result == -1 ? "❌ Element not found" : "✅ Found at index: " + result);
    }
}

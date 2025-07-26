import java.util.*;

public class KthLargestElementQuickSelect {
    public static int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private static int quickSelect(int[] nums, int low, int high, int k) {
        if (low == high) return nums[low];

        int pivotIndex = partition(nums, low, high);
        if (k == pivotIndex) return nums[k];
        else if (k < pivotIndex) return quickSelect(nums, low, pivotIndex - 1, k);
        else return quickSelect(nums, pivotIndex + 1, high, k);
    }

    private static int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = low;

        for (int j = low; j < high; j++) {
            if (nums[j] <= pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, high);
        return i;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.println("Kth Largest Element: " + findKthLargest(nums, k));
    }
}

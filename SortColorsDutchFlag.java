import java.util.*;

public class SortColorsDutchFlag {
    public static void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {
            switch (nums[mid]) {
                case 0:
                    int temp0 = nums[low];
                    nums[low++] = nums[mid];
                    nums[mid++] = temp0;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    int temp2 = nums[mid];
                    nums[mid] = nums[high];
                    nums[high--] = temp2;
                    break;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}

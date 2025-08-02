import java.util.*;

public class day33_minimumoperationsreducingx {
    public static int minOperations(int[] nums, int x) {
        int total = 0;
        for (int num : nums) total += num;
        int target = total - x;
        if (target < 0) return -1;

        int maxLen = -1, currSum = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            currSum += nums[right];
            while (currSum > target && left <= right) {
                currSum -= nums[left++];
            }
            if (currSum == target) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }
        return maxLen == -1 ? -1 : nums.length - maxLen;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 4, 2, 3};
        int x = 5;
        System.out.println("Minimum operations: " + minOperations(nums, x));
    }
}

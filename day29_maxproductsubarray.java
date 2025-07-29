public class MaxProductSubarray {

    public static int maxProduct(int[] nums) {
        int max = nums[0], min = nums[0], result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = max;
            max = Math.max(Math.max(nums[i], max * nums[i]), min * nums[i]);
            min = Math.min(Math.min(nums[i], temp * nums[i]), min * nums[i]);
            result = Math.max(result, max);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        System.out.println("Maximum Product Subarray: " + maxProduct(nums));
    }
}

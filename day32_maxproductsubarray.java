public class day32_maxproductsubarray {
    public static int maxProduct(int[] nums) {
        int max = nums[0], min = nums[0], result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int temp = max;
            max = Math.max(nums[i], Math.max(nums[i] * max, nums[i] * min));
            min = Math.min(nums[i], Math.min(nums[i] * temp, nums[i] * min));
            result = Math.max(result, max);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, -2, 4};
        System.out.println("Max Product Subarray: " + maxProduct(arr)); // Output: 6
    }
}

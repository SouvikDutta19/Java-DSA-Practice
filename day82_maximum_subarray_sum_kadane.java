public class day82_maximum_subarray_sum_kadane {
    public static int maxSubArray(int[] nums) {
        int maxSoFar = nums[0], curr = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curr = Math.max(nums[i], curr + nums[i]);
            maxSoFar = Math.max(maxSoFar, curr);
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("Maximum Subarray Sum: " + maxSubArray(nums));
    }
}

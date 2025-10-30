// day123_maximumsubarray.java
public class day123_maximumsubarray {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            cur = Math.max(nums[i], cur + nums[i]);
            maxSum = Math.max(maxSum, cur);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        day123_maximumsubarray obj = new day123_maximumsubarray();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("Maximum Subarray Sum: " + obj.maxSubArray(nums));
    }
}

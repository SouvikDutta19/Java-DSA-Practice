// day122_maximumproductsubarray.java
public class day122_maximumproductsubarray {
    public int maxProduct(int[] nums) {
        int max = nums[0], min = nums[0], result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(nums[i], max * nums[i]);
            min = Math.min(nums[i], min * nums[i]);
            result = Math.max(result, max);
        }
        return result;
    }

    public static void main(String[] args) {
        day122_maximumproductsubarray obj = new day122_maximumproductsubarray();
        int[] nums = {2,3,-2,4};
        System.out.println(obj.maxProduct(nums));
    }
}

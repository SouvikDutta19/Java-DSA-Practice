public class day163_max_product_subarray {

    public static int maxProduct(int[] nums) {
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
        int[] arr = {2, 3, -2, 4};

        System.out.println("Maximum product subarray = " + maxProduct(arr));
    }
}
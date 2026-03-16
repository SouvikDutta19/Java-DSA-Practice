public class day199_maximum_product_subarray {

    public static int maxProduct(int[] nums){

        int max = nums[0];
        int min = nums[0];
        int result = nums[0];

        for(int i=1;i<nums.length;i++){

            int temp = max;

            max = Math.max(Math.max(nums[i], nums[i]*max), nums[i]*min);
            min = Math.min(Math.min(nums[i], nums[i]*temp), nums[i]*min);

            result = Math.max(result, max);
        }

        return result;
    }

    public static void main(String[] args){

        int[] nums = {2,3,-2,4};

        System.out.println(maxProduct(nums));
    }
}
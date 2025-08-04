import java.util.Arrays;

public class day35_productarrayexceptself {
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];
        Arrays.fill(output, 1);

        int left = 1;
        for (int i = 0; i < n; i++) {
            output[i] = left;
            left *= nums[i];
        }

        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            output[i] *= right;
            right *= nums[i];
        }

        return output;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println("Product except self: " + Arrays.toString(productExceptSelf(nums)));
    }
}

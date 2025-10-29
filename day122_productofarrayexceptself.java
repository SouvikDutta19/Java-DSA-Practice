// day122_productofarrayexceptself.java
import java.util.*;

public class day122_productofarrayexceptself {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++)
            res[i] = res[i - 1] * nums[i - 1];

        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] = res[i] * right;
            right *= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        day122_productofarrayexceptself obj = new day122_productofarrayexceptself();
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(obj.productExceptSelf(nums)));
    }
}

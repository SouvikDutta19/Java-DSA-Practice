// day140_next_greater_element_stack.java

import java.util.*;

public class day140_next_greater_element_stack {

    public static int[] nextGreater(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                ans[stack.pop()] = nums[i];
            }
            stack.push(i);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, -3, -4, 6, 7, 2};
        System.out.println(Arrays.toString(nextGreater(arr)));
    }
}

import java.util.*;

public class SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[0];

        Deque<Integer> dq = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            while (!dq.isEmpty() && dq.peek() < i - k + 1) dq.poll();
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) dq.pollLast();

            dq.offer(i);
            if (i >= k - 1) res[i - k + 1] = nums[dq.peek()];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = maxSlidingWindow(nums, k);
        System.out.println("Sliding window maximums:");
        for (int val : result) System.out.print(val + " ");
    }
}

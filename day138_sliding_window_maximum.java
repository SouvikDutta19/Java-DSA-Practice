// day138_sliding_window_maximum.java
import java.util.*;

public class day138_sliding_window_maximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int idx = 0;

        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && dq.peekFirst() <= i - k)
                dq.pollFirst();

            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i])
                dq.pollLast();

            dq.offerLast(i);

            if (i >= k - 1)
                result[idx++] = nums[dq.peekFirst()];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,-1,-3,5,3,6,7};
        int[] res = maxSlidingWindow(arr, 3);

        System.out.print("Sliding Window Maximum: ");
        for (int x : res) System.out.print(x + " ");
    }
}

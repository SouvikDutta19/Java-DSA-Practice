import java.util.*;

public class SlidingWindowMax {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];
        int i = 0;

        for (int j = 0; j < nums.length; j++) {
            while (!deque.isEmpty() && deque.peek() < j - k + 1)
                deque.poll();

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[j])
                deque.pollLast();

            deque.offer(j);

            if (j >= k - 1)
                result[i++] = nums[deque.peek()];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] result = maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
        System.out.println(Arrays.toString(result));
    }
}

import java.util.*;

public class day210_sliding_window_maximum {

    public static int[] maxSlidingWindow(int[] nums, int k){

        Deque<Integer> dq = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];

        for(int i=0;i<nums.length;i++){

            while(!dq.isEmpty() && dq.peekFirst() <= i-k)
                dq.pollFirst();

            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i])
                dq.pollLast();

            dq.offerLast(i);

            if(i >= k-1)
                result[i-k+1] = nums[dq.peekFirst()];
        }

        return result;
    }
}
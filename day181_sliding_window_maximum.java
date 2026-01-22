import java.util.*;

public class day181_sliding_window_maximum {

    public static void maxWindow(int[] arr, int k) {
        Deque<Integer> dq = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {
            while (!dq.isEmpty() && dq.peekFirst() <= i - k)
                dq.pollFirst();

            while (!dq.isEmpty() && arr[dq.peekLast()] < arr[i])
                dq.pollLast();

            dq.addLast(i);

            if (i >= k - 1)
                System.out.print(arr[dq.peekFirst()] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,3,-1,-3,5,3,6,7};
        maxWindow(arr, 3);
    }
}
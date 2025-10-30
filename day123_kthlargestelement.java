// day123_kthlargestelement.java
import java.util.*;

public class day123_kthlargestelement {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n : nums) {
            pq.offer(n);
            if (pq.size() > k) pq.poll();
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        day123_kthlargestelement obj = new day123_kthlargestelement();
        int[] arr = {3,2,1,5,6,4};
        System.out.println("3rd largest element: " + obj.findKthLargest(arr, 3));
    }
}

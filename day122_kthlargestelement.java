// day122_kthlargestelement.java
import java.util.*;

public class day122_kthlargestelement {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n : nums) {
            pq.offer(n);
            if (pq.size() > k) pq.poll();
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        day122_kthlargestelement obj = new day122_kthlargestelement();
        int[] arr = {3,2,3,1,2,4,5,5,6};
        System.out.println(obj.findKthLargest(arr, 4));
    }
}

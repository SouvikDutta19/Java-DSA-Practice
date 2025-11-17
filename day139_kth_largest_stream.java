// day139_kth_largest_stream.java

import java.util.*;

public class day139_kth_largest_stream {

    static class KthLargest {
        private PriorityQueue<Integer> pq;
        private int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            pq = new PriorityQueue<>();

            for (int num : nums) add(num);
        }

        public int add(int val) {
            pq.offer(val);
            if (pq.size() > k) pq.poll();
            return pq.peek();
        }
    }

    public static void main(String[] args) {
        KthLargest kth = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println(kth.add(3));
        System.out.println(kth.add(5));
        System.out.println(kth.add(10));
        System.out.println(kth.add(9));
    }
}

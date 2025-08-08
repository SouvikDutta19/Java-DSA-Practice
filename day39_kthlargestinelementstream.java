// Kth Largest Element in a Stream using Min Heap

import java.util.*;

public class day39_kthlargestinelementstream {
    private PriorityQueue<Integer> minHeap;
    private int k;

    public day39_kthlargestinelementstream(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        minHeap.offer(val);
        if (minHeap.size() > k)
            minHeap.poll();
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 8, 2};
        day39_kthlargestinelementstream kthLargest = new day39_kthlargestinelementstream(3, nums);
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));
    }
}

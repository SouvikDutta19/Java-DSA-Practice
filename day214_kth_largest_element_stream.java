import java.util.*;

public class day214_kth_largest_element_stream {

    PriorityQueue<Integer> minHeap;
    int k;

    public day214_kth_largest_element_stream(
            int k,
            int[] nums) {

        this.k = k;

        minHeap = new PriorityQueue<>();

        for (int num : nums)
            add(num);
    }

    public int add(int val) {

        minHeap.offer(val);

        if (minHeap.size() > k)
            minHeap.poll();

        return minHeap.peek();
    }
}
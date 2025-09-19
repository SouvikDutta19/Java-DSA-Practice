import java.util.*;

public class day83_kth_largest_stream {
    PriorityQueue<Integer> minHeap;
    int k;

    public day83_kth_largest_stream(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();
        for (int n : nums) add(n);
    }

    public int add(int val) {
        if (minHeap.size() < k) minHeap.add(val);
        else if (val > minHeap.peek()) {
            minHeap.poll();
            minHeap.add(val);
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] nums = {4,5,8,2};
        day83_kth_largest_stream obj = new day83_kth_largest_stream(3, nums);
        System.out.println(obj.add(3));
        System.out.println(obj.add(5));
        System.out.println(obj.add(10));
        System.out.println(obj.add(9));
        System.out.println(obj.add(4));
    }
}

// Day148 Kth Smallest using heap (max-heap of size k)
import java.util.*;
public class Day148KthSmallestHeap {
    public static int kthSmallest(int[] arr, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int v: arr){
            pq.offer(v);
            if(pq.size() > k) pq.poll();
        }
        return pq.peek();
    }
    public static void main(String[] args){
        int[] a = {7,10,4,3,20,15};
        System.out.println("3rd smallest = " + kthSmallest(a,3)); // 7
    }
}

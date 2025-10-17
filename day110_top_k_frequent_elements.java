// Program to find Top K Frequent Elements in an Array using Priority Queue

import java.util.*;

public class day110_top_k_frequent_elements {
    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums)
            freq.put(num, freq.getOrDefault(num, 0) + 1);

        PriorityQueue<Map.Entry<Integer, Integer>> heap =
            new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            heap.add(entry);
            if (heap.size() > k) heap.poll();
        }

        List<Integer> res = new ArrayList<>();
        while (!heap.isEmpty())
            res.add(heap.poll().getKey());

        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3,3,3,4,5,5,5,5};
        int k = 2;
        System.out.println("Top " + k + " frequent elements: " + topKFrequent(nums, k));
    }
}

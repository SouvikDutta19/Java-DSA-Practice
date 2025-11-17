// day139_top_k_frequent_elements.java

import java.util.*;

public class day139_top_k_frequent_elements {

    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) freq.put(num, freq.getOrDefault(num, 0) + 1);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        for (int key : freq.keySet()) {
            pq.offer(new int[]{key, freq.get(key)});
            if (pq.size() > k) pq.poll();
        }

        List<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) result.add(pq.poll()[0]);

        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2, 3};
        System.out.println(topKFrequent(arr, 2));
    }
}

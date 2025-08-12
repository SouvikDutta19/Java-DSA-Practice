import java.util.*;

public class day43_top_k_frequent_elements {
    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
            (a, b) -> b.getValue() - a.getValue()
        );
        pq.addAll(freqMap.entrySet());

        List<Integer> result = new ArrayList<>();
        while (k-- > 0 && !pq.isEmpty()) {
            result.add(pq.poll().getKey());
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3,3,3,3,4};
        int k = 2;
        System.out.println("Top K Frequent Elements: " + topKFrequent(nums, k));
    }
}

import java.util.*;

public class Day189TopKFrequentElements {

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        PriorityQueue<Integer> pq =
                new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));

        for (int num : map.keySet()) {
            pq.add(num);
            if (pq.size() > k) pq.poll();
        }

        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--)
            result[i] = pq.poll();

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int[] res = topKFrequent(nums, 2);

        for (int n : res)
            System.out.print(n + " ");
    }
}
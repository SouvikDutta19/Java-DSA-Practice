// day121_topkfrequentelements.java
import java.util.*;

public class day121_topkfrequentelements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) map.put(n, map.getOrDefault(n, 0) + 1);

        PriorityQueue<Map.Entry<Integer, Integer>> pq =
                new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) pq.poll();
        }

        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--)
            res[i] = pq.poll().getKey();
        return res;
    }

    public static void main(String[] args) {
        day121_topkfrequentelements obj = new day121_topkfrequentelements();
        int[] nums = {1,1,1,2,2,3};
        System.out.println(Arrays.toString(obj.topKFrequent(nums, 2)));
    }
}

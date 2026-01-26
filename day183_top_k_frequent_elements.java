import java.util.*;

public class day183_top_k_frequent_elements {

    public static void topK(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : arr)
            map.put(n, map.getOrDefault(n, 0) + 1);

        PriorityQueue<Integer> pq =
            new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));

        for (int key : map.keySet()) {
            pq.add(key);
            if (pq.size() > k)
                pq.poll();
        }

        while (!pq.isEmpty())
            System.out.print(pq.poll() + " ");
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3};
        topK(arr, 2);
    }
}
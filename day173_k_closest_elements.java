import java.util.*;

public class day173_k_closest_elements {

    public static List<Integer> findClosest(int[] arr, int k, int x) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0]-a[0]);
        
        for(int val : arr) {
            pq.add(new int[]{Math.abs(val-x), val});
            if(pq.size() > k) pq.poll();
        }

        List<Integer> result = new ArrayList<>();
        while(!pq.isEmpty()) result.add(pq.poll()[1]);
        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(findClosest(arr, 4, 3));
    }
}
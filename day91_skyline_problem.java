import java.util.*;

public class day91_skyline_problem {
    public static List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        List<int[]> heights = new ArrayList<>();

        for (int[] b : buildings) {
            heights.add(new int[]{b[0], -b[2]});
            heights.add(new int[]{b[1], b[2]});
        }

        Collections.sort(heights, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(0);
        int prev = 0;

        for (int[] h : heights) {
            if (h[1] < 0) pq.add(-h[1]);
            else pq.remove(h[1]);

            int curr = pq.peek();
            if (curr != prev) {
                res.add(new int[]{h[0], curr});
                prev = curr;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] buildings = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
        List<int[]> result = getSkyline(buildings);
        for (int[] r : result) System.out.println(Arrays.toString(r));
    }
}

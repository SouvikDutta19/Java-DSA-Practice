import java.util.*;

public class SkylineProblem {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        List<int[]> heights = new ArrayList<>();
        for (int[] b : buildings) {
            heights.add(new int[]{b[0], -b[2]});
            heights.add(new int[]{b[1], b[2]});
        }

        heights.sort((a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(0);
        int prev = 0;

        for (int[] h : heights) {
            if (h[1] < 0) pq.add(-h[1]);
            else pq.remove(h[1]);

            int curr = pq.peek();
            if (curr != prev) {
                result.add(new int[]{h[0], curr});
                prev = curr;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        SkylineProblem obj = new SkylineProblem();
        int[][] buildings = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
        List<int[]> skyline = obj.getSkyline(buildings);
        for (int[] point : skyline) {
            System.out.println(Arrays.toString(point));
        }
    }
}

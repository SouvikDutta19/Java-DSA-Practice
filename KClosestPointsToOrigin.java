import java.util.*;

public class KClosestPointsToOrigin {
    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) ->
            Integer.compare(distance(b), distance(a)));
        for (int[] p : points) {
            pq.offer(p);
            if (pq.size() > k) pq.poll();
        }

        int[][] res = new int[k][2];
        while (k-- > 0) res[k] = pq.poll();
        return res;
    }

    private static int distance(int[] point) {
        return point[0]*point[0] + point[1]*point[1];
    }

    public static void main(String[] args) {
        int[][] points = {{3,3},{5,-1},{-2,4}};
        int k = 2;
        int[][] res = kClosest(points, k);
        for (int[] p : res) System.out.println(Arrays.toString(p));
    }
}

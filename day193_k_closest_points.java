import java.util.PriorityQueue;

public class Day193KClosestPoints {

    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap =
                new PriorityQueue<>((a, b) ->
                        (b[0]*b[0] + b[1]*b[1]) -
                        (a[0]*a[0] + a[1]*a[1]));

        for (int[] point : points) {
            maxHeap.add(point);
            if (maxHeap.size() > k)
                maxHeap.poll();
        }

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++)
            result[i] = maxHeap.poll();

        return result;
    }

    public static void main(String[] args) {
        int[][] points = {{1,3},{-2,2}};
        int[][] res = kClosest(points, 1);

        for (int[] p : res)
            System.out.println(p[0] + " " + p[1]);
    }
}
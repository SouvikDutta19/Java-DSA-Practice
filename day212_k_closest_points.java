import java.util.*;

public class day212_k_closest_points {

    public static int[][] kClosest(int[][] points, int k){

        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a,b) ->
                        (b[0]*b[0] + b[1]*b[1]) -
                        (a[0]*a[0] + a[1]*a[1]));

        for(int[] p : points){

            pq.add(p);

            if(pq.size() > k)
                pq.poll();
        }

        int[][] result = new int[k][2];

        for(int i=0;i<k;i++)
            result[i] = pq.poll();

        return result;
    }
}
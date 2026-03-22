import java.util.*;

public class day201_skyline_problem {

    public static List<List<Integer>> getSkyline(int[][] buildings){

        List<int[]> events = new ArrayList<>();

        for(int[] b : buildings){
            events.add(new int[]{b[0], -b[2]});
            events.add(new int[]{b[1], b[2]});
        }

        Collections.sort(events, (a,b) -> {
            if(a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });

        PriorityQueue<Integer> pq =
                new PriorityQueue<>(Collections.reverseOrder());
        pq.add(0);

        int prev = 0;
        List<List<Integer>> result = new ArrayList<>();

        for(int[] e : events){

            if(e[1] < 0)
                pq.add(-e[1]);
            else
                pq.remove(e[1]);

            int curr = pq.peek();

            if(curr != prev){
                result.add(Arrays.asList(e[0], curr));
                prev = curr;
            }
        }

        return result;
    }
}
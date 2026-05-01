import java.util.*;

public class day209_minimum_number_of_refueling_stops {

    public static int minRefuelStops(int target, int startFuel, int[][] stations){

        PriorityQueue<Integer> pq =
                new PriorityQueue<>(Collections.reverseOrder());

        int fuel = startFuel, i = 0, stops = 0;

        while(fuel < target){

            while(i < stations.length && stations[i][0] <= fuel){
                pq.add(stations[i][1]);
                i++;
            }

            if(pq.isEmpty()) return -1;

            fuel += pq.poll();
            stops++;
        }

        return stops;
    }
}
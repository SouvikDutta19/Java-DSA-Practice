import java.util.*;

public class day83_meeting_rooms_ii {
    public static int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= minHeap.peek()) {
                minHeap.poll();
            }
            minHeap.add(intervals[i][1]);
        }
        return minHeap.size();
    }

    public static void main(String[] args) {
        int[][] meetings = {{0,30},{5,10},{15,20}};
        System.out.println("Minimum Meeting Rooms Required: " + minMeetingRooms(meetings));
    }
}

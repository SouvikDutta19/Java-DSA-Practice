import java.util.*;

public class IntervalPartitioning {
    static class Interval {
        int start, end;
        Interval(int s, int e) {
            start = s; end = e;
        }
    }

    public static int minResourcesRequired(List<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(i -> i.start));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (Interval interval : intervals) {
            if (!pq.isEmpty() && pq.peek() <= interval.start)
                pq.poll();
            pq.offer(interval.end);
        }

        return pq.size();
    }

    public static void main(String[] args) {
        List<Interval> intervals = Arrays.asList(
            new Interval(0, 30),
            new Interval(5, 10),
            new Interval(15, 20),
            new Interval(25, 35)
        );
        System.out.println("Minimum resources required: " + minResourcesRequired(intervals));
    }
}

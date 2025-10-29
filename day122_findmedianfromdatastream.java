// day122_findmedianfromdatastream.java
import java.util.*;

public class day122_findmedianfromdatastream {
    static class MedianFinder {
        PriorityQueue<Integer> low = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> high = new PriorityQueue<>();

        public void addNum(int num) {
            low.offer(num);
            high.offer(low.poll());
            if (low.size() < high.size()) low.offer(high.poll());
        }

        public double findMedian() {
            return low.size() > high.size() ? low.peek() : (low.peek() + high.peek()) / 2.0;
        }
    }

    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        mf.addNum(2);
        System.out.println(mf.findMedian());
        mf.addNum(3);
        System.out.println(mf.findMedian());
    }
}

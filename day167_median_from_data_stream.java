import java.util.*;

public class day167_median_from_data_stream {

    static class MedianFinder {
        PriorityQueue<Integer> left =
                new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> right =
                new PriorityQueue<>();

        void addNum(int num) {
            left.add(num);
            right.add(left.poll());

            if (left.size() < right.size())
                left.add(right.poll());
        }

        double findMedian() {
            if (left.size() > right.size())
                return left.peek();
            return (left.peek() + right.peek()) / 2.0;
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
import java.util.*;

public class day90_find_median_from_data_stream {
    PriorityQueue<Integer> low, high;

    public day90_find_median_from_data_stream() {
        low = new PriorityQueue<>(Collections.reverseOrder());
        high = new PriorityQueue<>();
    }

    public void addNum(int num) {
        low.add(num);
        high.add(low.poll());
        if (low.size() < high.size()) low.add(high.poll());
    }

    public double findMedian() {
        if (low.size() == high.size()) return (low.peek() + high.peek()) / 2.0;
        return low.peek();
    }

    public static void main(String[] args) {
        day90_find_median_from_data_stream medianFinder = new day90_find_median_from_data_stream();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println("Median: " + medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println("Median: " + medianFinder.findMedian());
    }
}

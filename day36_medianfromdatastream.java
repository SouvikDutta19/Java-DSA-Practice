import java.util.*;

public class day36_medianfromdatastream {
    PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> large = new PriorityQueue<>();

    public void addNum(int num) {
        small.add(num);
        if (!large.isEmpty() && small.peek() > large.peek()) {
            large.add(small.poll());
        }
        if (small.size() > large.size() + 1) {
            large.add(small.poll());
        } else if (large.size() > small.size()) {
            small.add(large.poll());
        }
    }

    public double findMedian() {
        if (small.size() == large.size())
            return (small.peek() + large.peek()) / 2.0;
        else
            return small.peek();
    }

    public static void main(String[] args) {
        day36_medianfromdatastream mf = new day36_medianfromdatastream();
        mf.addNum(1);
        mf.addNum(2);
        System.out.println("Median: " + mf.findMedian());  // Output: 1.5
        mf.addNum(3);
        System.out.println("Median: " + mf.findMedian());  // Output: 2
    }
}

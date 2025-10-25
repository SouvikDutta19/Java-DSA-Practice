import java.util.*;

public class day118_median_of_stream {
    PriorityQueue<Integer> lower = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> higher = new PriorityQueue<>();

    void addNum(int num) {
        if (lower.isEmpty() || num <= lower.peek())
            lower.add(num);
        else
            higher.add(num);

        if (lower.size() > higher.size() + 1)
            higher.add(lower.poll());
        else if (higher.size() > lower.size())
            lower.add(higher.poll());
    }

    double findMedian() {
        if (lower.size() == higher.size())
            return (lower.peek() + higher.peek()) / 2.0;
        else
            return lower.peek();
    }

    public static void main(String[] args) {
        day118_median_of_stream stream = new day118_median_of_stream();
        int[] arr = {5, 15, 1, 3};
        for (int num : arr) {
            stream.addNum(num);
            System.out.println("After inserting " + num + ", Median = " + stream.findMedian());
        }
    }
}

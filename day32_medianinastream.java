import java.util.*;

public class day32_medianinastream {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    public void addNum(int num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek())
            maxHeap.add(num);
        else
            minHeap.add(num);

        if (maxHeap.size() > minHeap.size() + 1)
            minHeap.add(maxHeap.poll());
        else if (minHeap.size() > maxHeap.size())
            maxHeap.add(minHeap.poll());
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size())
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        else
            return maxHeap.peek();
    }

    public static void main(String[] args) {
        day32_medianinastream medianFinder = new day32_medianinastream();
        int[] stream = {5, 15, 1, 3};
        for (int num : stream) {
            medianFinder.addNum(num);
            System.out.println("Current Median: " + medianFinder.findMedian());
        }
    }
}

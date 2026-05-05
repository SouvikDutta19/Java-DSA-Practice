import java.util.*;

public class day210_median_of_data_stream {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public day210_median_of_data_stream(){

        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num){

        maxHeap.add(num);
        minHeap.add(maxHeap.poll());

        if(maxHeap.size() < minHeap.size())
            maxHeap.add(minHeap.poll());
    }

    public double findMedian(){

        if(maxHeap.size() > minHeap.size())
            return maxHeap.peek();

        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}
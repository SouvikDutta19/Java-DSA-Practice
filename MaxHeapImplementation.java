import java.util.*;

public class MaxHeapImplementation {
    static class MaxHeap {
        List<Integer> heap;

        public MaxHeap() {
            heap = new ArrayList<>();
        }

        void insert(int val) {
            heap.add(val);
            int i = heap.size() - 1;

            while (i > 0) {
                int parent = (i - 1) / 2;
                if (heap.get(i) <= heap.get(parent)) break;

                Collections.swap(heap, i, parent);
                i = parent;
            }
        }

        int extractMax() {
            if (heap.isEmpty()) return -1;

            int max = heap.get(0);
            int last = heap.remove(heap.size() - 1);
            if (!heap.isEmpty()) heap.set(0, last);

            int i = 0;
            while (i < heap.size()) {
                int left = 2 * i + 1;
                int right = 2 * i + 2;
                int largest = i;

                if (left < heap.size() && heap.get(left) > heap.get(largest)) largest = left;
                if (right < heap.size() && heap.get(right) > heap.get(largest)) largest = right;

                if (largest == i) break;

                Collections.swap(heap, i, largest);
                i = largest;
            }
            return max;
        }

        void printHeap() {
            System.out.println("Heap: " + heap);
        }
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.insert(10);
        maxHeap.insert(20);
        maxHeap.insert(5);
        maxHeap.insert(30);

        maxHeap.printHeap();
        System.out.println("Max extracted: " + maxHeap.extractMax());
        maxHeap.printHeap();
    }
}

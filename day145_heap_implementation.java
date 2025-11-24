import java.util.*;

public class day145_heap_implementation {

    static class MinHeap {
        ArrayList<Integer> heap = new ArrayList<>();

        int parent(int i) { return (i-1)/2; }
        int left(int i) { return 2*i + 1; }
        int right(int i) { return 2*i + 2; }

        void insert(int val) {
            heap.add(val);
            int i = heap.size() - 1;

            while (i > 0 && heap.get(parent(i)) > heap.get(i)) {
                Collections.swap(heap, i, parent(i));
                i = parent(i);
            }
        }

        int extractMin() {
            if (heap.isEmpty()) return -1;
            int root = heap.get(0);

            heap.set(0, heap.get(heap.size() - 1));
            heap.remove(heap.size() - 1);
            heapify(0);

            return root;
        }

        void heapify(int i) {
            int smallest = i;
            int l = left(i), r = right(i);

            if (l < heap.size() && heap.get(l) < heap.get(smallest)) smallest = l;
            if (r < heap.size() && heap.get(r) < heap.get(smallest)) smallest = r;

            if (smallest != i) {
                Collections.swap(heap, i, smallest);
                heapify(smallest);
            }
        }
    }

    public static void main(String[] args) {
        MinHeap h = new MinHeap();
        h.insert(10);
        h.insert(5);
        h.insert(20);
        h.insert(3);

        System.out.println(h.extractMin());
        System.out.println(h.extractMin());
    }
}

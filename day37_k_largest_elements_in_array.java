import java.util.PriorityQueue;

public class day37_k_largest_elements_in_array {
    public static int[] kLargest(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : arr) {
            pq.add(i);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[] result = new int[k];
        int idx = 0;
        while (!pq.isEmpty()) {
            result[idx++] = pq.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {10, 2, 30, 14, 8, 25, 7};
        int k = 3;
        int[] largest = kLargest(arr, k);
        System.out.print("K largest elements: ");
        for (int num : largest) {
            System.out.print(num + " ");
        }
    }
}

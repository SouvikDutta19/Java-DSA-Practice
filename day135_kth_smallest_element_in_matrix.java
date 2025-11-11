import java.util.*;

public class day135_kth_smallest_element_in_matrix {
    public static int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int[] row : matrix)
            for (int val : row)
                pq.add(val);
        for (int i = 1; i < k; i++)
            pq.poll();
        return pq.peek();
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
        int k = 8;
        System.out.println("Kth smallest element: " + kthSmallest(matrix, k));
    }
}

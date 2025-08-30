import java.util.*;

public class day61_maximum_sum_rectangle {
    static int kadane(int[] arr, int n) {
        int maxSoFar = arr[0], maxEndingHere = arr[0];
        for (int i = 1; i < n; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    static int maximumSumRectangle(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int maxSum = Integer.MIN_VALUE;

        for (int left = 0; left < cols; left++) {
            int[] temp = new int[rows];
            for (int right = left; right < cols; right++) {
                for (int i = 0; i < rows; i++) {
                    temp[i] += mat[i][right];
                }
                int currentMax = kadane(temp, rows);
                maxSum = Math.max(maxSum, currentMax);
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, -1, -4, -20},
            {-8, -3, 4, 2, 1},
            {3, 8, 10, 1, 3},
            {-4, -1, 1, 7, -6}
        };
        System.out.println("Maximum sum rectangle: " + maximumSumRectangle(matrix));
    }
}

import java.util.*;

public class day45_maximum_sum_rectangle_in_matrix {

    static int kadane(int[] arr) {
        int maxSum = arr[0], currentSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    public static int maxSumRectangle(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int maxSum = Integer.MIN_VALUE;

        for (int left = 0; left < cols; left++) {
            int[] temp = new int[rows];
            for (int right = left; right < cols; right++) {
                for (int i = 0; i < rows; i++) {
                    temp[i] += matrix[i][right];
                }
                maxSum = Math.max(maxSum, kadane(temp));
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
        System.out.println("Maximum sum rectangle: " + maxSumRectangle(matrix));
    }
}

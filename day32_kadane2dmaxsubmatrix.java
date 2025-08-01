public class day32_kadane2dmaxsubmatrix {
    public static int maxSumRectangle(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxSum = Integer.MIN_VALUE;

        for (int left = 0; left < cols; left++) {
            int[] temp = new int[rows];

            for (int right = left; right < cols; right++) {
                for (int i = 0; i < rows; i++)
                    temp[i] += matrix[i][right];

                int currentMax = kadane(temp);
                maxSum = Math.max(maxSum, currentMax);
            }
        }
        return maxSum;
    }

    private static int kadane(int[] arr) {
        int max = arr[0], sum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sum = Math.max(arr[i], sum + arr[i]);
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, -1, -4, -20},
            {-8, -3, 4, 2, 1},
            {3, 8, 10, 1, 3},
            {-4, -1, 1, 7, -6}
        };
        System.out.println("Max 2D Submatrix Sum: " + maxSumRectangle(matrix)); // Output: 29
    }
}

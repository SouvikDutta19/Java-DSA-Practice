public class day83_maximum_sum_submatrix {
    public static int maxSumSubmatrix(int[][] matrix, int k) {
        int rows = matrix.length, cols = matrix[0].length, max = Integer.MIN_VALUE;
        for (int left = 0; left < cols; left++) {
            int[] rowSum = new int[rows];
            for (int right = left; right < cols; right++) {
                for (int i = 0; i < rows; i++) rowSum[i] += matrix[i][right];
                max = Math.max(max, kadane(rowSum, k));
            }
        }
        return max;
    }

    private static int kadane(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum <= k) max = Math.max(max, sum);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,0,1},{0,-2,3}};
        int k = 2;
        System.out.println("Max Sum Submatrix <= k: " + maxSumSubmatrix(matrix, k));
    }
}

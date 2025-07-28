public class KnapsackRecursive {
    public static int knapsack(int[] weights, int[] values, int n, int w) {
        if (n == 0 || w == 0) return 0;

        if (weights[n - 1] > w)
            return knapsack(weights, values, n - 1, w);

        return Math.max(values[n - 1] + knapsack(weights, values, n - 1, w - weights[n - 1]),
                        knapsack(weights, values, n - 1, w));
    }

    public static void main(String[] args) {
        int[] weights = {2, 3, 4, 5};
        int[] values = {3, 4, 5, 6};
        int capacity = 5;

        System.out.println("Max value in knapsack = " + knapsack(weights, values, weights.length, capacity));
    }
}

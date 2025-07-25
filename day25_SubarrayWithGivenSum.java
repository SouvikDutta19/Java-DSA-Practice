import java.util.*;

public class day25_SubarrayWithGivenSum {
    public static void findSubarrayWithSum(int[] arr, int target) {
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        int currentSum = 0;
        prefixSumMap.put(0, -1);

        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];

            if (prefixSumMap.containsKey(currentSum - target)) {
                int start = prefixSumMap.get(currentSum - target) + 1;
                int end = i;
                System.out.println("Subarray found from index " + start + " to " + end);
                return;
            }

            prefixSumMap.put(currentSum, i);
        }

        System.out.println("No subarray with the given sum found.");
    }

    public static void main(String[] args) {
        int[] arr = {10, 2, -2, -20, 10};
        int target = -10;
        findSubarrayWithSum(arr, target);
    }
}

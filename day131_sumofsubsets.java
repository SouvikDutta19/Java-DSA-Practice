// day131_sumofsubsets.java
import java.util.*;

public class day131_sumofsubsets {
    static void subsetSum(int[] arr, int n, int target, ArrayList<Integer> subset) {
        if (target == 0) {
            System.out.println(subset);
            return;
        }
        if (n == 0 || target < 0)
            return;
        subset.add(arr[n - 1]);
        subsetSum(arr, n - 1, target - arr[n - 1], subset);
        subset.remove(subset.size() - 1);
        subsetSum(arr, n - 1, target, subset);
    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 5, 18, 12, 20, 15};
        int target = 35;
        subsetSum(arr, arr.length, target, new ArrayList<>());
    }
}

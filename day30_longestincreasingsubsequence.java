import java.util.*;

public class day30_longestincreasingsubsequence {
    public static int lengthOfLIS(int[] nums) {
        ArrayList<Integer> sub = new ArrayList<>();
        for (int num : nums) {
            int i = Collections.binarySearch(sub, num);
            if (i < 0) i = -(i + 1);
            if (i == sub.size()) sub.add(num);
            else sub.set(i, num);
        }
        return sub.size();
    }

    public static void main(String[] args) {
        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(arr));  // Output: 4
    }
}

import java.util.*;

public class day60_longest_increasing_subsequence {
    public static int lengthOfLIS(int[] nums) {
        List<Integer> dp = new ArrayList<>();
        for (int num : nums) {
            int idx = Collections.binarySearch(dp, num);
            if (idx < 0) idx = -(idx + 1);
            if (idx == dp.size()) dp.add(num);
            else dp.set(idx, num);
        }
        return dp.size();
    }

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println("Length of LIS: " + lengthOfLIS(nums));
    }
}

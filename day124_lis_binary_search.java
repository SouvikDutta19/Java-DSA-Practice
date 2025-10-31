// day124_lis_binary_search.java
import java.util.*;

public class day124_lis_binary_search {
    // patience sorting-style O(n log n)
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        ArrayList<Integer> tails = new ArrayList<>();
        for (int x : nums) {
            int idx = Collections.binarySearch(tails, x);
            if (idx < 0) idx = -idx - 1;
            if (idx == tails.size()) tails.add(x);
            else tails.set(idx, x);
        }
        return tails.size();
    }

    public static void main(String[] args) {
        day124_lis_binary_search obj = new day124_lis_binary_search();
        int[] arr = {10,9,2,5,3,7,101,18};
        System.out.println("Length of LIS: " + obj.lengthOfLIS(arr));
    }
}

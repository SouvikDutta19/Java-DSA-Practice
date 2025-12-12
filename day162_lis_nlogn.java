// Day162 - Longest Increasing Subsequence (O(n log n) patience)
import java.util.*;

public class day162_lis_nlogn {
    public static int lengthOfLIS(int[] a) {
        ArrayList<Integer> tails = new ArrayList<>();
        for (int x : a) {
            int idx = Collections.binarySearch(tails, x);
            if (idx < 0) idx = -idx - 1;
            if (idx == tails.size()) tails.add(x);
            else tails.set(idx, x);
        }
        return tails.size();
    }

    public static void main(String[] args) {
        int[] a = {10,9,2,5,3,7,101,18};
        System.out.println("LIS length = " + lengthOfLIS(a)); // 4
    }
}
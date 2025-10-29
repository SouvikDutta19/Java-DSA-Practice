// day122_longestconsecutivesequence.java
import java.util.*;

public class day122_longestconsecutivesequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) set.add(n);
        int best = 0;
        for (int n : set) {
            if (!set.contains(n - 1)) { // start of sequence
                int cur = n;
                int length = 1;
                while (set.contains(cur + 1)) {
                    cur++;
                    length++;
                }
                best = Math.max(best, length);
            }
        }
        return best;
    }

    public static void main(String[] args) {
        day122_longestconsecutivesequence obj = new day122_longestconsecutivesequence();
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println("Longest consecutive sequence length: " + obj.longestConsecutive(nums));
    }
}

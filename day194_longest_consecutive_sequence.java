import java.util.*;

public class Day194LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums)
            set.add(num);

        int max = 0;

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int current = num;
                int length = 1;

                while (set.contains(current + 1)) {
                    current++;
                    length++;
                }

                max = Math.max(max, length);
            }
        }

        return max;
    }
}
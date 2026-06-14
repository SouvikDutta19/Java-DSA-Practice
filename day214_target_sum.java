import java.util.*;

public class day214_target_sum {

    public static int findTargetSumWays(
            int[] nums,
            int target) {

        Map<String, Integer> memo =
                new HashMap<>();

        return dfs(nums,
                   0,
                   0,
                   target,
                   memo);
    }

    static int dfs(int[] nums,
                   int index,
                   int currentSum,
                   int target,
                   Map<String, Integer> memo) {

        if (index == nums.length)
            return currentSum == target ? 1 : 0;

        String key =
                index + "," + currentSum;

        if (memo.containsKey(key))
            return memo.get(key);

        int add =
                dfs(nums,
                    index + 1,
                    currentSum + nums[index],
                    target,
                    memo);

        int subtract =
                dfs(nums,
                    index + 1,
                    currentSum - nums[index],
                    target,
                    memo);

        memo.put(key, add + subtract);

        return memo.get(key);
    }
}
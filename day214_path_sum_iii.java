import java.util.*;

public class day214_path_sum_iii {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int pathSum(TreeNode root,
                              int targetSum) {

        Map<Long, Integer> prefixMap =
                new HashMap<>();

        prefixMap.put(0L, 1);

        return dfs(root,
                   0,
                   targetSum,
                   prefixMap);
    }

    static int dfs(TreeNode node,
                   long currentSum,
                   int target,
                   Map<Long, Integer> map) {

        if (node == null)
            return 0;

        currentSum += node.val;

        int count =
                map.getOrDefault(
                        currentSum - target,
                        0
                );

        map.put(currentSum,
                map.getOrDefault(
                        currentSum,
                        0
                ) + 1);

        count += dfs(node.left,
                     currentSum,
                     target,
                     map);

        count += dfs(node.right,
                     currentSum,
                     target,
                     map);

        map.put(currentSum,
                map.get(currentSum) - 1);

        return count;
    }
}
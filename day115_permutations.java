import java.util.*;

public class day115_permutations {
    public static void backtrack(List<List<Integer>> res, List<Integer> temp, int[] nums) {
        if (temp.size() == nums.length) res.add(new ArrayList<>(temp));
        else {
            for (int i = 0; i < nums.length; i++) {
                if (temp.contains(nums[i])) continue;
                temp.add(nums[i]);
                backtrack(res, temp, nums);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), nums);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println("All permutations: " + permute(nums));
    }
}

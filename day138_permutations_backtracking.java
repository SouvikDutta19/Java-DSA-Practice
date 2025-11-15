// day138_permutations_backtracking.java
import java.util.*;

public class day138_permutations_backtracking {

    static List<List<Integer>> result = new ArrayList<>();

    public static List<List<Integer>> permute(int[] nums) {
        backtrack(nums, new boolean[nums.length], new ArrayList<>());
        return result;
    }

    private static void backtrack(int[] nums, boolean[] used, List<Integer> temp) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                temp.add(nums[i]);
                backtrack(nums, used, temp);
                used[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println("Permutations: " + permute(arr));
    }
}

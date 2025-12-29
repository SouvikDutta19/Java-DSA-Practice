import java.util.*;

public class day173_subset_sum_backtracking {

    static List<List<Integer>> result = new ArrayList<>();

    public static void find(int[] arr, int target, int index, List<Integer> temp) {
        if(target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        if(target < 0 || index == arr.length) return;

        temp.add(arr[index]);
        find(arr, target - arr[index], index+1, temp);
        temp.remove(temp.size()-1);

        find(arr, target, index+1, temp);
    }

    public static void main(String[] args) {
        int[] arr = {2,3,6,7};
        find(arr, 7, 0, new ArrayList<>());
        System.out.println("Subsets: " + result);
    }
}
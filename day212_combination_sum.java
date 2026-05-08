import java.util.*;

public class day212_combination_sum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target){

        List<List<Integer>> result = new ArrayList<>();

        backtrack(candidates, target, 0,
                new ArrayList<>(), result);

        return result;
    }

    static void backtrack(int[] arr, int target,
                          int index,
                          List<Integer> temp,
                          List<List<Integer>> result){

        if(target == 0){
            result.add(new ArrayList<>(temp));
            return;
        }

        if(target < 0)
            return;

        for(int i=index;i<arr.length;i++){

            temp.add(arr[i]);

            backtrack(arr, target-arr[i],
                    i, temp, result);

            temp.remove(temp.size()-1);
        }
    }
}
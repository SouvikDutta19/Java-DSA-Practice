import java.util.*;

public class day164_longest_increasing_subsequence {

    public static int lis(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for (int num : nums) {
            int idx = Collections.binarySearch(list, num);
            if (idx < 0) idx = -(idx + 1);

            if (idx == list.size())
                list.add(num);
            else
                list.set(idx, num);
        }
        return list.size();
    }

    public static void main(String[] args) {
        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("LIS Length = " + lis(arr));
    }
}
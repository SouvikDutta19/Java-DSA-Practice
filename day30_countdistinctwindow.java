import java.util.*;

public class day30_countdistinctwindow {
    public static List<Integer> countDistinct(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            if (i >= k) {
                map.put(arr[i - k], map.get(arr[i - k]) - 1);
                if (map.get(arr[i - k]) == 0)
                    map.remove(arr[i - k]);
            }
            if (i >= k - 1) result.add(map.size());
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 4, 2, 3};
        System.out.println(countDistinct(arr, 4)); // [3,4,4,3]
    }
}

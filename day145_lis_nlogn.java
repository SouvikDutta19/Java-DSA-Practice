import java.util.*;

public class day145_lis_nlogn {

    static int LIS(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int num : arr) {
            int idx = Collections.binarySearch(list, num);
            if (idx < 0) idx = -(idx + 1);

            if (idx == list.size()) list.add(num);
            else list.set(idx, num);
        }
        return list.size();
    }

    public static void main(String[] args) {
        int[] arr = {10,9,2,5,3,7,101,18};
        System.out.println("LIS Length: " + LIS(arr));
    }
}

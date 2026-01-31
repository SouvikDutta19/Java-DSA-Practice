import java.util.*;

public class day184_minimum_platforms {

    static int findPlatforms(int[] arr, int[] dep) {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int i = 0, j = 0, plat = 0, max = 0;

        while (i < arr.length && j < dep.length) {
            if (arr[i] <= dep[j]) {
                plat++;
                max = Math.max(max, plat);
                i++;
            } else {
                plat--;
                j++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {900,940,950,1100,1500,1800};
        int[] dep = {910,1200,1120,1130,1900,2000};
        System.out.println(findPlatforms(arr, dep));
    }
}
import java.util.*;

public class day143_min_platforms {

    public static int findPlatforms(int[] arr, int[] dep) {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int platNeeded = 1, result = 1;
        int i = 1, j = 0;
        int n = arr.length;

        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                platNeeded++;
                i++;
            } else {
                platNeeded--;
                j++;
            }
            result = Math.max(result, platNeeded);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {900, 940, 950, 1100, 1500, 1800};
        int[] dep = {910, 1200, 1120, 1130, 1900, 2000};
        System.out.println("Minimum Platforms Required: " + findPlatforms(arr, dep));
    }
}

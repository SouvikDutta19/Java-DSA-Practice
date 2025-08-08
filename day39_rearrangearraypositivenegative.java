// Rearranging Array in Positive, Negative Alternating Order with O(1) space

import java.util.*;

public class day39_rearrangearraypositivenegative {

    public static void rearrange(int[] arr) {
        int n = arr.length;
        int i = -1;

        for (int j = 0; j < n; j++) {
            if (arr[j] < 0) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int pos = i + 1, neg = 0;

        while (pos < n && neg < pos && arr[neg] < 0) {
            int temp = arr[neg];
            arr[neg] = arr[pos];
            arr[pos] = temp;
            pos++;
            neg += 2;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, -4, -1, 4};
        rearrange(arr);
        System.out.println("Rearranged Array: " + Arrays.toString(arr));
    }
}

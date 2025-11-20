import java.util.*;

public class day142_longest_bitonic {

    public static int longestBitonic(int[] arr) {
        int n = arr.length;

        int[] lis = new int[n];
        int[] lds = new int[n];

        Arrays.fill(lis, 1);
        Arrays.fill(lds, 1);

        for (int i = 1; i < n; i++)
            for (int j = 0; j < i; j++)
                if (arr[i] > arr[j])
                    lis[i] = Math.max(lis[i], lis[j] + 1);

        for (int i = n - 2; i >= 0; i--)
            for (int j = n - 1; j > i; j--)
                if (arr[i] > arr[j])
                    lds[i] = Math.max(lds[i], lds[j] + 1);

        int max = 1;
        for (int i = 0; i < n; i++)
            max = Math.max(max, lis[i] + lds[i] - 1);

        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1, 11, 2, 10, 4, 5, 2, 1};
        System.out.println("Longest Bitonic Subsequence Length: " + longestBitonic(arr));
    }
}

import java.util.*;

public class day101_lis {
    static int lis(int arr[], int n) {
        int lis[] = new int[n];
        Arrays.fill(lis, 1);
        for (int i = 1; i < n; i++)
            for (int j = 0; j < i; j++)
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1)
                    lis[i] = lis[j] + 1;
        return Arrays.stream(lis).max().getAsInt();
    }

    public static void main(String args[]) {
        int arr[] = {10, 22, 9, 33, 21, 50, 41, 60};
        System.out.println("Length of LIS = " + lis(arr, arr.length));
    }
}

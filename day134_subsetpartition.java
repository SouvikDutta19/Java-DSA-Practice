// day134_subsetpartition.java
public class day134_subsetpartition {
    static boolean isSubsetSum(int arr[], int n, int sum) {
        boolean subset[][] = new boolean[sum + 1][n + 1];
        for (int i = 0; i <= n; i++)
            subset[0][i] = true;
        for (int i = 1; i <= sum; i++)
            subset[i][0] = false;

        for (int i = 1; i <= sum; i++)
            for (int j = 1; j <= n; j++) {
                subset[i][j] = subset[i][j - 1];
                if (i >= arr[j - 1])
                    subset[i][j] = subset[i][j] || subset[i - arr[j - 1]][j - 1];
            }

        return subset[sum][n];
    }

    static boolean findPartition(int arr[], int n) {
        int sum = 0;
        for (int num : arr) sum += num;
        if (sum % 2 != 0)
            return false;
        return isSubsetSum(arr, n, sum / 2);
    }

    public static void main(String[] args) {
        int arr[] = {1, 5, 11, 5};
        if (findPartition(arr, arr.length))
            System.out.println("Can be divided into two subsets of equal sum");
        else
            System.out.println("Cannot be divided into two subsets of equal sum");
    }
}

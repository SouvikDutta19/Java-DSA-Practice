public class day97_matrixchainmultiplication {
    static int MatrixChainOrder(int p[], int n) {
        int m[][] = new int[n][n];
        for (int L = 2; L < n; L++) {
            for (int i = 1; i < n - L + 1; i++) {
                int j = i + L - 1;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    int q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (q < m[i][j]) m[i][j] = q;
                }
            }
        }
        return m[1][n - 1];
    }

    public static void main(String args[]) {
        int arr[] = {1, 2, 3, 4};
        int n = arr.length;
        System.out.println("Minimum multiplications: " + MatrixChainOrder(arr, n));
    }
}

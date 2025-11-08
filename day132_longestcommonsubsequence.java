// day132_longestcommonsubsequence.java
public class day132_longestcommonsubsequence {
    static int lcs(String X, String Y, int m, int n) {
        int[][] L = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else if (X.charAt(i - 1) == Y.charAt(j - 1))
                    L[i][j] = L[i - 1][j - 1] + 1;
                else
                    L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
            }
        }
        return L[m][n];
    }

    public static void main(String[] args) {
        String X = "AGGTAB";
        String Y = "GXTXAYB";
        System.out.println("Length of LCS is " + lcs(X, Y, X.length(), Y.length()));
    }
}

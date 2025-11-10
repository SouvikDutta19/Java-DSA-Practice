// day134_palindromepartitioning.java
public class day134_palindromepartitioning {
    static int minPalPartion(String str) {
        int n = str.length();
        int C[][] = new int[n][n];
        boolean P[][] = new boolean[n][n];

        for (int i = 0; i < n; i++)
            P[i][i] = true;

        for (int L = 2; L <= n; L++) {
            for (int i = 0; i < n - L + 1; i++) {
                int j = i + L - 1;
                if (L == 2)
                    P[i][j] = (str.charAt(i) == str.charAt(j));
                else
                    P[i][j] = (str.charAt(i) == str.charAt(j)) && P[i + 1][j - 1];
            }
        }

        for (int i = 0; i < n; i++) {
            if (P[0][i])
                C[0][i] = 0;
            else {
                C[0][i] = Integer.MAX_VALUE;
                for (int j = 0; j < i; j++)
                    if (P[j + 1][i] && 1 + C[0][j] < C[0][i])
                        C[0][i] = 1 + C[0][j];
            }
        }
        return C[0][n - 1];
    }

    public static void main(String[] args) {
        String str = "ababbbabbababa";
        System.out.println("Min cuts needed for Palindrome Partitioning: " + minPalPartion(str));
    }
}

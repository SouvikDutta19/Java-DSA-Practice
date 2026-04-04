import java.util.*;

public class day206_bitmask_dp_tsp {

    static int[][] dp;
    static int[][] dist;
    static int n;

    public static int tsp(int mask, int pos){

        if(mask == (1<<n)-1)
            return dist[pos][0];

        if(dp[mask][pos] != -1)
            return dp[mask][pos];

        int ans = Integer.MAX_VALUE;

        for(int city=0;city<n;city++){
            if((mask & (1<<city)) == 0){
                int newAns = dist[pos][city] +
                        tsp(mask | (1<<city), city);
                ans = Math.min(ans, newAns);
            }
        }

        return dp[mask][pos] = ans;
    }

    public static int solve(int[][] matrix){

        dist = matrix;
        n = matrix.length;

        dp = new int[1<<n][n];
        for(int[] row : dp)
            Arrays.fill(row, -1);

        return tsp(1,0);
    }
}
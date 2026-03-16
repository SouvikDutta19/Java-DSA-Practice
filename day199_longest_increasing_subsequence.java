import java.util.*;

public class day199_longest_increasing_subsequence {

    public static int lengthOfLIS(int[] nums){

        int[] dp = new int[nums.length];
        int len = 0;

        for(int num : nums){

            int i = Arrays.binarySearch(dp,0,len,num);

            if(i < 0) i = -(i+1);

            dp[i] = num;

            if(i == len) len++;
        }

        return len;
    }

    public static void main(String[] args){

        int[] nums = {10,9,2,5,3,7,101,18};

        System.out.println(lengthOfLIS(nums));
    }
}
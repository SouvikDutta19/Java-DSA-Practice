public class day150_longestsubarraygivensum {

    public static int longestSubarray(int[] arr, int target) {
        int left = 0, right = 0, sum = 0, maxLen = 0;

        while (right < arr.length) {
            sum += arr[right];

            while (sum > target && left <= right) {
                sum -= arr[left];
                left++;
            }

            if (sum == target) {
                maxLen = Math.max(maxLen, right - left + 1);
            }

            right++;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 1, 1, 2, 3};
        int target = 6;

        System.out.println("Longest subarray length = " + longestSubarray(arr, target));
    }
}

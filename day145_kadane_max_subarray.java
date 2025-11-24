public class day145_kadane_max_subarray {

    public static void kadane(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int curr = 0;
        int start = 0, s = 0, end = 0;

        for (int i = 0; i < arr.length; i++) {
            curr += arr[i];

            if (curr > maxSum) {
                maxSum = curr;
                start = s;
                end = i;
            }

            if (curr < 0) {
                curr = 0;
                s = i + 1;
            }
        }

        System.out.println("Max Sum = " + maxSum);
        System.out.print("Subarray: ");
        for (int i = start; i <= end; i++) System.out.print(arr[i] + " ");
    }

    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        kadane(arr);
    }
}

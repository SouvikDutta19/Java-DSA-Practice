// day134_minjumps.java
public class day134_minjumps {
    static int minJumps(int arr[], int n) {
        if (n <= 1)
            return 0;
        if (arr[0] == 0)
            return -1;

        int maxReach = arr[0], step = arr[0], jump = 1;
        for (int i = 1; i < n; i++) {
            if (i == n - 1)
                return jump;
            maxReach = Math.max(maxReach, i + arr[i]);
            step--;
            if (step == 0) {
                jump++;
                if (i >= maxReach)
                    return -1;
                step = maxReach - i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.println("Minimum number of jumps: " + minJumps(arr, arr.length));
    }
}

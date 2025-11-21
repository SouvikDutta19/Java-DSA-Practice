import java.util.*;

public class day143_activity_selection {

    public static int selectActivities(int[] start, int[] end) {
        int n = start.length;
        int[][] act = new int[n][2];

        for (int i = 0; i < n; i++) {
            act[i][0] = start[i];
            act[i][1] = end[i];
        }

        Arrays.sort(act, Comparator.comparingInt(a -> a[1]));

        int count = 1;
        int lastEnd = act[0][1];

        System.out.println("Selected Activities:");
        System.out.println("(" + act[0][0] + ", " + act[0][1] + ")");

        for (int i = 1; i < n; i++) {
            if (act[i][0] >= lastEnd) {
                count++;
                lastEnd = act[i][1];
                System.out.println("(" + act[i][0] + ", " + act[i][1] + ")");
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] s = {1, 3, 0, 5, 8, 5};
        int[] e = {2, 4, 6, 7, 9, 9};
        System.out.println("\nTotal Activities Selected: " + selectActivities(s, e));
    }
}

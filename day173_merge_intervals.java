import java.util.*;

public class day173_merge_intervals {

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> list = new ArrayList<>();

        for (int[] interval : intervals) {
            if (list.isEmpty() || list.get(list.size() - 1)[1] < interval[0]) {
                list.add(interval);
            } else {
                list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], interval[1]);
            }
        }
        return list.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] arr = {{1,3},{2,6},{8,10},{15,18}};
        int[][] result = merge(arr);
        for(int[] i : result)
            System.out.println(Arrays.toString(i));
    }
}
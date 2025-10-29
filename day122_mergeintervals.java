// day122_mergeintervals.java
import java.util.*;

public class day122_mergeintervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][];
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> res = new ArrayList<>();
        int[] cur = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= cur[1]) {
                cur[1] = Math.max(cur[1], intervals[i][1]);
            } else {
                res.add(cur);
                cur = intervals[i];
            }
        }
        res.add(cur);
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        day122_mergeintervals obj = new day122_mergeintervals();
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] merged = obj.merge(intervals);
        System.out.println("Merged intervals:");
        for (int[] in : merged) System.out.println(Arrays.toString(in));
    }
}

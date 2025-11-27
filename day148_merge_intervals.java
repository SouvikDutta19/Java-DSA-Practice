// Day148 Merge Intervals (sorting + merge)
import java.util.*;
public class Day148MergeIntervals {
    public static int[][] merge(int[][] intervals){
        if(intervals.length <= 1) return intervals;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> res = new ArrayList<>();
        int[] cur = intervals[0];
        for(int i=1;i<intervals.length;i++){
            int[] it = intervals[i];
            if(it[0] <= cur[1]){ // overlap
                cur[1] = Math.max(cur[1], it[1]);
            } else {
                res.add(cur);
                cur = it;
            }
        }
        res.add(cur);
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args){
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18},{17,20}};
        int[][] merged = merge(intervals);
        System.out.println("Merged intervals:");
        for(int[] arr: merged){
            System.out.println(Arrays.toString(arr));
        }
    }
}

// day135_activity_selection_problem.java
// Greedy Activity Selection (select maximum number of non-overlapping intervals)

import java.util.*;

public class day135_activity_selection_problem {
    static class Activity {
        int start, finish;
        Activity(int s, int f) { start = s; finish = f; }
    }

    static List<Activity> selectActivities(Activity[] acts) {
        Arrays.sort(acts, Comparator.comparingInt(a -> a.finish));
        List<Activity> selected = new ArrayList<>();
        int lastFinish = -1;
        for (Activity a : acts) {
            if (a.start > lastFinish) {
                selected.add(a);
                lastFinish = a.finish;
            }
        }
        return selected;
    }

    public static void main(String[] args) {
        Activity[] acts = {
            new Activity(1, 2), new Activity(3, 4), new Activity(0, 6),
            new Activity(5, 7), new Activity(8, 9), new Activity(5, 9)
        };
        List<Activity> res = selectActivities(acts);
        System.out.println("Selected activities (start -> finish):");
        for (Activity a : res) System.out.println(a.start + " -> " + a.finish);
    }
}

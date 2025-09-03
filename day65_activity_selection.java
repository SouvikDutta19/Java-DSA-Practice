import java.util.*;

public class day65_activity_selection {
    static class Activity {
        int start, finish;
        Activity(int s, int f) { start = s; finish = f; }
    }

    public static void selectActivities(List<Activity> activities) {
        activities.sort(Comparator.comparingInt(a -> a.finish));
        List<Activity> result = new ArrayList<>();
        result.add(activities.get(0));

        int lastFinish = activities.get(0).finish;
        for (int i = 1; i < activities.size(); i++) {
            if (activities.get(i).start >= lastFinish) {
                result.add(activities.get(i));
                lastFinish = activities.get(i).finish;
            }
        }

        System.out.println("Selected Activities:");
        for (Activity a : result)
            System.out.println("(" + a.start + "," + a.finish + ")");
    }

    public static void main(String[] args) {
        List<Activity> activities = Arrays.asList(
                new Activity(1, 3), new Activity(2, 5),
                new Activity(4, 6), new Activity(6, 8),
                new Activity(5, 9), new Activity(8, 10)
        );
        selectActivities(activities);
    }
}

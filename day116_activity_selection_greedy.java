import java.util.*;

class Activity {
    int start, finish;
    Activity(int s, int f) {
        start = s;
        finish = f;
    }
}

public class day116_activity_selection_greedy {

    static void selectActivities(List<Activity> activities) {
        activities.sort(Comparator.comparingInt(a -> a.finish));

        int i = 0;
        System.out.println("Selected activities:");
        System.out.println("(" + activities.get(i).start + ", " + activities.get(i).finish + ")");
        for (int j = 1; j < activities.size(); j++) {
            if (activities.get(j).start >= activities.get(i).finish) {
                System.out.println("(" + activities.get(j).start + ", " + activities.get(j).finish + ")");
                i = j;
            }
        }
    }

    public static void main(String[] args) {
        List<Activity> activities = Arrays.asList(
            new Activity(5, 9), new Activity(1, 2),
            new Activity(3, 4), new Activity(0, 6),
            new Activity(5, 7), new Activity(8, 9)
        );
        selectActivities(activities);
    }
}

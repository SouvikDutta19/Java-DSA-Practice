import java.util.*;

class Job {
    char id;
    int deadline, profit;
    public Job(char id, int deadline, int profit) {
        this.id = id; this.deadline = deadline; this.profit = profit;
    }
}

public class day116_job_scheduling_with_deadlines {

    static void jobScheduling(Job[] arr, int n) {
        Arrays.sort(arr, (a, b) -> b.profit - a.profit);
        boolean[] slot = new boolean[n];
        char[] result = new char[n];

        for (int i = 0; i < n; i++) {
            for (int j = Math.min(n, arr[i].deadline) - 1; j >= 0; j--) {
                if (!slot[j]) {
                    slot[j] = true;
                    result[j] = arr[i].id;
                    break;
                }
            }
        }
        System.out.println("Scheduled Jobs:");
        for (char c : result)
            if (c != 0)
                System.out.print(c + " ");
    }

    public static void main(String[] args) {
        Job[] jobs = {
            new Job('A', 2, 100),
            new Job('B', 1, 19),
            new Job('C', 2, 27),
            new Job('D', 1, 25),
            new Job('E', 3, 15)
        };
        jobScheduling(jobs, jobs.length);
    }
}

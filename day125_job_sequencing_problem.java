// day125_job_sequencing_problem.java
import java.util.*;

class Job {
    int id, deadline, profit;
    Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class day125_job_sequencing_problem {
    static void jobScheduling(Job[] jobs, int n) {
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);
        boolean[] slot = new boolean[n];
        int totalProfit = 0;

        for (int i = 0; i < n; i++) {
            for (int j = Math.min(n - 1, jobs[i].deadline - 1); j >= 0; j--) {
                if (!slot[j]) {
                    slot[j] = true;
                    totalProfit += jobs[i].profit;
                    break;
                }
            }
        }
        System.out.println("Maximum Profit: " + totalProfit);
    }

    public static void main(String[] args) {
        Job[] jobs = {
            new Job(1, 2, 100),
            new Job(2, 1, 19),
            new Job(3, 2, 27),
            new Job(4, 1, 25),
            new Job(5, 3, 15)
        };
        jobScheduling(jobs, 3);
    }
}

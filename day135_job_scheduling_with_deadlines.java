// day135_job_scheduling_with_deadlines.java
// Greedy job sequencing to maximize profit with deadlines

import java.util.*;

class JobDS {
    String id;
    int deadline, profit;
    JobDS(String i, int d, int p) { id = i; deadline = d; profit = p; }
}

public class day135_job_scheduling_with_deadlines {
    static void scheduleJobs(JobDS[] jobs) {
        Arrays.sort(jobs, (a,b) -> b.profit - a.profit);
        int maxDeadline = 0;
        for (JobDS j : jobs) maxDeadline = Math.max(maxDeadline, j.deadline);
        String[] result = new String[maxDeadline];
        boolean[] slot = new boolean[maxDeadline];

        int totalProfit = 0;
        for (JobDS job : jobs) {
            for (int d = Math.min(maxDeadline, job.deadline) - 1; d >= 0; d--) {
                if (!slot[d]) {
                    slot[d] = true;
                    result[d] = job.id;
                    totalProfit += job.profit;
                    break;
                }
            }
        }

        System.out.println("Scheduled jobs:");
        for (String s : result) if (s != null) System.out.print(s + " ");
        System.out.println("\nTotal Profit: " + totalProfit);
    }

    public static void main(String[] args) {
        JobDS[] jobs = {
            new JobDS("a", 2, 100),
            new JobDS("b", 1, 19),
            new JobDS("c", 2, 27),
            new JobDS("d", 1, 25),
            new JobDS("e", 3, 15)
        };
        scheduleJobs(jobs);
    }
}

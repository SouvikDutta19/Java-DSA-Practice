import java.util.*;

class Job {
    char id;
    int deadline, profit;

    public Job(char id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class day55_job_sequencing {
    public static void printJobScheduling(Job[] jobs, int n) {
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        int maxDeadline = 0;
        for (Job job : jobs) maxDeadline = Math.max(maxDeadline, job.deadline);

        char[] result = new char[maxDeadline + 1];
        boolean[] slot = new boolean[maxDeadline + 1];

        for (int i = 0; i < n; i++) {
            for (int j = jobs[i].deadline; j > 0; j--) {
                if (!slot[j]) {
                    result[j] = jobs[i].id;
                    slot[j] = true;
                    break;
                }
            }
        }

        System.out.println("Job sequence for max profit:");
        for (int i = 1; i <= maxDeadline; i++) {
            if (slot[i]) System.out.print(result[i] + " ");
        }
    }

    public static void main(String[] args) {
        Job[] jobs = {
            new Job('a', 2, 100),
            new Job('b', 1, 19),
            new Job('c', 2, 27),
            new Job('d', 1, 25),
            new Job('e', 3, 15)
        };
        printJobScheduling(jobs, jobs.length);
    }
}

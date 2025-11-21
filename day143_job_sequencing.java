import java.util.*;

class Job {
    char id;
    int deadline;
    int profit;

    Job(char id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class day143_job_sequencing {

    public static void jobSequencing(Job[] jobs) {
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        int maxDeadline = 0;
        for (Job j : jobs) maxDeadline = Math.max(maxDeadline, j.deadline);

        char[] result = new char[maxDeadline + 1];
        boolean[] slot = new boolean[maxDeadline + 1];
        Arrays.fill(result, '-');

        int totalProfit = 0;

        for (Job job : jobs) {
            for (int d = job.deadline; d > 0; d--) {
                if (!slot[d]) {
                    slot[d] = true;
                    result[d] = job.id;
                    totalProfit += job.profit;
                    break;
                }
            }
        }

        System.out.println("Job Sequence:");
        for (int i = 1; i <= maxDeadline; i++)
            System.out.print(result[i] + " ");

        System.out.println("\nTotal Profit: " + totalProfit);
    }

    public static void main(String[] args) {
        Job[] jobs = {
                new Job('A', 2, 100),
                new Job('B', 1, 19),
                new Job('C', 2, 27),
                new Job('D', 1, 25),
                new Job('E', 3, 15)
        };
        jobSequencing(jobs);
    }
}

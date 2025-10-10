import java.util.*;

// Job Sequencing Problem for maximum profit
class Job {
    int id, deadline, profit;
    Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class day104_job_sequencing {
    public static int[] jobScheduling(Job[] arr, int n) {
        Arrays.sort(arr, (a, b) -> b.profit - a.profit);
        int maxDeadline = 0;
        for (Job j : arr)
            maxDeadline = Math.max(maxDeadline, j.deadline);

        int[] result = new int[maxDeadline + 1];
        Arrays.fill(result, -1);
        int countJobs = 0, jobProfit = 0;

        for (Job job : arr) {
            for (int j = job.deadline; j > 0; j--) {
                if (result[j] == -1) {
                    result[j] = job.id;
                    countJobs++;
                    jobProfit += job.profit;
                    break;
                }
            }
        }
        return new int[]{countJobs, jobProfit};
    }

    public static void main(String[] args) {
        Job[] jobs = {new Job(1, 4, 20), new Job(2, 1, 10), new Job(3, 1, 40), new Job(4, 1, 30)};
        int[] ans = jobScheduling(jobs, jobs.length);
        System.out.println("Total Jobs Done: " + ans[0] + ", Total Profit: " + ans[1]);
    }
}

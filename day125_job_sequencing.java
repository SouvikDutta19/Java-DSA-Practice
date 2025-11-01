import java.util.*;

class Job {
    char id;
    int deadline, profit;
    Job(char id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class day125_job_sequencing {

    static void jobSequencing(Job[] jobs) {
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);
        int maxDeadline = 0;
        for (Job j : jobs)
            maxDeadline = Math.max(maxDeadline, j.deadline);

        char[] result = new char[maxDeadline];
        boolean[] slot = new boolean[maxDeadline];

        for (Job job : jobs) {
            for (int j = Math.min(maxDeadline - 1, job.deadline - 1); j >= 0; j--) {
                if (!slot[j]) {
                    result[j] = job.id;
                    slot[j] = true;
                    break;
                }
            }
        }

        System.out.print("Job sequence for max profit: ");
        for (boolean s : slot)
            if (s) System.out.print(result[Arrays.asList(slot).indexOf(s)] + " ");
    }

    public static void main(String[] args) {
        Job[] arr = { new Job('A', 2, 100), new Job('B', 1, 19),
                      new Job('C', 2, 27), new Job('D', 1, 25),
                      new Job('E', 3, 15) };
        jobSequencing(arr);
    }
}

import java.util.*;

class Job {
    char id;
    int deadline, profit;
    Job(char id, int deadline, int profit) {
        this.id = id; this.deadline = deadline; this.profit = profit;
    }
}

public class day87_job_sequencing {
    static void jobScheduling(Job[] jobs) {
        Arrays.sort(jobs, (a,b)->b.profit - a.profit);
        int n = jobs.length;
        boolean[] slot = new boolean[n];
        char[] result = new char[n];
        for (Job job : jobs) {
            for (int j = Math.min(n, job.deadline)-1; j >= 0; j--) {
                if (!slot[j]) {
                    slot[j] = true;
                    result[j] = job.id;
                    break;
                }
            }
        }
        System.out.println("Scheduled jobs: " + Arrays.toString(result));
    }

    public static void main(String[] args) {
        Job[] jobs = {
            new Job('a', 2, 100),
            new Job('b', 1, 19),
            new Job('c', 2, 27),
            new Job('d', 1, 25),
            new Job('e', 3, 15)
        };
        jobScheduling(jobs);
    }
}

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

public class day116_job_sequencing_deadlines {

    static void jobSequencing(List<Job> jobs) {
        jobs.sort((a, b) -> b.profit - a.profit);
        int n = jobs.size();
        boolean[] slot = new boolean[n];
        char[] result = new char[n];

        for (Job job : jobs) {
            for (int j = Math.min(n - 1, job.deadline - 1); j >= 0; j--) {
                if (!slot[j]) {
                    slot[j] = true;
                    result[j] = job.id;
                    break;
                }
            }
        }

        System.out.println("Job sequence for maximum profit:");
        for (char id : result)
            if (id != 0)
                System.out.print(id + " ");
    }

    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(
            new Job('a', 2, 100),
            new Job('b', 1, 19),
            new Job('c', 2, 27),
            new Job('d', 1, 25),
            new Job('e', 3, 15)
        );
        jobSequencing(jobs);
    }
}

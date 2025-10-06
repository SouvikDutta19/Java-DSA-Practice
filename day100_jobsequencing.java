import java.util.*;

class Job {
    char id;
    int deadline, profit;
    Job(char id, int deadline, int profit) {
        this.id = id; this.deadline = deadline; this.profit = profit;
    }
}

public class day100_jobsequencing {
    static void jobSequencing(List<Job> jobs, int n) {
        Collections.sort(jobs, (a, b) -> b.profit - a.profit);
        boolean[] slot = new boolean[n];
        char[] result = new char[n];
        int totalProfit = 0;

        for (Job job : jobs) {
            for (int j = Math.min(n, job.deadline) - 1; j >= 0; j--) {
                if (!slot[j]) {
                    slot[j] = true;
                    result[j] = job.id;
                    totalProfit += job.profit;
                    break;
                }
            }
        }

        System.out.print("Job Order: ");
        for (char c : result) if (c != 0) System.out.print(c + " ");
        System.out.println("\nTotal Profit: " + totalProfit);
    }

    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(
                new Job('a', 2, 100),
                new Job('b', 1, 19),
                new Job('c', 2, 27),
                new Job('d', 1, 25),
                new Job('e', 3, 15)
        );
        jobSequencing(jobs, 3);
    }
}

import java.util.*;

class Job {
    int id, deadline, profit;
    Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class day31_jobsequencingdsu {
    static int find(int[] parent, int s) {
        if (parent[s] == s) return s;
        return parent[s] = find(parent, parent[s]);
    }

    static void union(int[] parent, int u, int v) {
        parent[v] = u;
    }

    public static void printJobScheduling(List<Job> jobs, int maxDeadline) {
        Collections.sort(jobs, (a, b) -> b.profit - a.profit);
        int[] parent = new int[maxDeadline + 1];
        for (int i = 0; i <= maxDeadline; i++) parent[i] = i;

        int jobCount = 0, totalProfit = 0;
        for (Job job : jobs) {
            int availableSlot = find(parent, job.deadline);
            if (availableSlot > 0) {
                union(parent, find(parent, availableSlot - 1), availableSlot);
                jobCount++;
                totalProfit += job.profit;
                System.out.println("Job " + job.id + " scheduled at slot " + availableSlot);
            }
        }
        System.out.println("Total Jobs: " + jobCount + ", Total Profit: " + totalProfit);
    }

    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(
            new Job(1, 2, 100),
            new Job(2, 1, 19),
            new Job(3, 2, 27),
            new Job(4, 1, 25),
            new Job(5, 3, 15)
        );
        printJobScheduling(jobs, 3);
    }
}

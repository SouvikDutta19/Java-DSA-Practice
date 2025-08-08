// Job Sequencing with Deadlines and Profit Maximization using Greedy + Disjoint Set

import java.util.*;

class Job {
    int id, deadline, profit;

    Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class day39_maximumprofitjobsequencing {

    static int find(int[] parent, int s) {
        if (parent[s] == s)
            return s;
        return parent[s] = find(parent, parent[s]);
    }

    static void union(int[] parent, int u, int v) {
        parent[v] = u;
    }

    public static int jobScheduling(Job[] jobs) {
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        int maxDeadline = 0;
        for (Job job : jobs) {
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }

        int[] parent = new int[maxDeadline + 1];
        for (int i = 0; i <= maxDeadline; i++) parent[i] = i;

        int profit = 0;
        for (Job job : jobs) {
            int availableSlot = find(parent, job.deadline);
            if (availableSlot > 0) {
                profit += job.profit;
                union(parent, find(parent, availableSlot - 1), availableSlot);
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        Job[] jobs = {
            new Job(1, 2, 100),
            new Job(2, 1, 19),
            new Job(3, 2, 27),
            new Job(4, 1, 25),
            new Job(5, 3, 15)
        };

        System.out.println("Maximum Profit: " + jobScheduling(jobs));
    }
}

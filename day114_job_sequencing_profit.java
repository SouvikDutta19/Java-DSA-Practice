// day114_job_sequencing_profit.java
// Job Sequencing with Deadlines to maximize profit (greedy using DSU or PQ).
// This implementation uses greedy scheduling with a max-heap and boolean slots (disjoint-set optimization could be used).
import java.util.*;
class Main {
    static class Job { int id, deadline, profit; Job(int i,int d,int p){id=i;deadline=d;profit=p;} }
    public static int maxProfit(List<Job> jobs){
        // sort by profit descending
        jobs.sort((a,b)->Integer.compare(b.profit,a.profit));
        int maxDead = 0;
        for(Job j: jobs) maxDead = Math.max(maxDead, j.deadline);
        boolean[] slot = new boolean[maxDead+1];
        int totalProfit=0;
        for(Job j: jobs){
            for(int d=Math.min(maxDead, j.deadline); d>0; d--){
                if(!slot[d]){
                    slot[d]=true;
                    totalProfit += j.profit;
                    break;
                }
            }
        }
        return totalProfit;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Job> jobs = new ArrayList<>();
        for(int i=0;i<n;i++){
            int id = sc.nextInt(), dl = sc.nextInt(), pf = sc.nextInt();
            jobs.add(new Job(id,dl,pf));
        }
        System.out.println(maxProfit(jobs));
        sc.close();
    }
}

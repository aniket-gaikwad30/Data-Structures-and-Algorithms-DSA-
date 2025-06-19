import java.util.ArrayList;
import java.util.Collections;

public class JobSeq {

    static class Job {
        int deadline;
        int profit;
        int id;

        public Job(int d, int p, int i) {
            deadline = d;
            profit = p;
            id = i;
        }
    }

    public static void main(String[] args) {

        int jobInfo[][] = { {4, 20}, {1, 10}, {1, 40}, {1, 30} };

        ArrayList<Job> jobs = new ArrayList<>();

        // Step 1: Store jobs with their info
        for (int i = 0; i < jobInfo.length; i++) {
            jobs.add(new Job(jobInfo[i][0], jobInfo[i][1], i));
        }

        // Step 2: Sort jobs by profit in descending order
        Collections.sort(jobs, (a, b) -> b.profit - a.profit);

        ArrayList<Integer> seq = new ArrayList<>();
        int time = 0;
        int totalProfit = 0;

        // Step 3: Select jobs greedily if within deadline limit
        for (int i = 0; i < jobs.size(); i++) {
            Job curr = jobs.get(i);

            if (curr.deadline > time) {
                seq.add(curr.id);
                time++;
                totalProfit += curr.profit;
            }
        }

        // Step 4: Output the result
        System.out.println("Selected job IDs (by index): " + seq);
        System.out.println("Total Profit: " + totalProfit);
    }
}

import java.util.*;

public class Jobs {
    long[] jobTimes;

    private long minTime(long aTotal, long bTotal, long cTotal, int index) {
        if (index == jobTimes.length) {
            return Math.max(aTotal, Math.max(bTotal, cTotal));
        } else {
            long currTime = jobTimes[index];
            long first = minTime(aTotal + currTime, bTotal, cTotal, index + 1);
            long second = minTime(aTotal, bTotal + currTime, cTotal, index + 1);
            long third = minTime(aTotal, bTotal, cTotal + currTime, index + 1);
            return Math.min(first, Math.min(second, third));
        }
    }
    private void run() {
        Scanner sc = new Scanner(System.in);
        int numJobs = sc.nextInt();
        jobTimes = new long[numJobs];

        for (int i = 0; i < numJobs; i++) {
            jobTimes[i] = sc.nextLong();
        }

        long ans = minTime(0, 0, 0, 0);
        System.out.println(ans);
    }

    public static void main(String args[]) {
        Jobs runner = new Jobs();
        runner.run();
    }
}

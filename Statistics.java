import java.util.*;

public class Statistics {
	private void run() {
		Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[] arrNums = new long[n];

        for (int i = 0; i < n; i++) {
            arrNums[i] = sc.nextLong();
        }

        long sum = Arrays.stream(arrNums).sum();

        double avg = (double)sum / (double)n;

        System.out.println("Sum: " + sum);
        System.out.printf("Average: %.2f\n", avg);
 

	}
	
	public static void main(String[] args) {
		Statistics newStatistics = new Statistics();
		newStatistics.run();
	}
}

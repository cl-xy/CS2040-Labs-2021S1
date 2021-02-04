import java.util.*;

public class Add {
    PriorityQueue<Long> pq = new PriorityQueue<>();
    long add = 0;
    private void run() {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();

        for (int i = 0; i < q; i++) {
            int type = sc.nextInt();
            if (type == 1) {
                long value = sc.nextInt();
                pq.add(value - add);
            } else if (type == 2) {
                long addValue = sc.nextInt();
                add += addValue;
            } else {
                if (pq.peek() == null) {
                    System.out.println("None");
                } else {
                    System.out.println(pq.poll() + add);
                }
            }
        }
    }

    public static void main(String args[]) {
        Add runner = new Add();
        runner.run();
    }
}

import java.util.*;

public class Median {
    public class reverseComp implements Comparator<Integer> {
        public int compare(Integer a, Integer b) {
            return b - a;
        }
    }

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new reverseComp());

    private void queryOne(int value) {
        if (minHeap.peek() == null && maxHeap.peek() == null) {
            maxHeap.add(value);
        } else if (value < maxHeap.peek()) {
            maxHeap.add(value);
        } else if (value >= maxHeap.peek()) {
            minHeap.add(value);
        }

        while (minHeap.size() > maxHeap.size() + 1) {
            maxHeap.add(minHeap.remove());
        }

        while (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.remove());
        }
    }

    private void run() {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        
        for (int i = 0; i < q; i++) {
            int type = sc.nextInt();
            if (type == 1) {
                queryOne(sc.nextInt());
            } else {
                if (maxHeap.size() == 0 && minHeap.size() == 0) {
                    System.out.println("None");
                }
                else if (maxHeap.size() == minHeap.size()) {
                    System.out.println(String.format("%s %s", maxHeap.peek(), minHeap.peek()));
                } else if (minHeap.size() > maxHeap.size()) {
                    System.out.println(minHeap.peek());
                } else {
                    System.out.println(maxHeap.peek());
                }
            }
        }
    }

    public static void main(String args[]) {
        Median runner = new Median();
        runner.run();
    }
}

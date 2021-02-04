import java.util.*;

public class Board {
    public class Cell {
        public int value;
        public int row;
        public int col;

        public Cell(int value, int row, int col) {
            this.value = value;
            this.row = row;
            this.col = col;
        }
    }

    private void run() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] a = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        PriorityQueue<Cell> rows[] = new PriorityQueue[N];
        PriorityQueue<Cell> cols[] = new PriorityQueue[N];

        Comparator<Cell> comp = new Comparator<Cell>() {
            @Override
            public int compare(Cell a, Cell b) {
                return b.value - a.value;
            }
        };

        for (int i = 0; i < N; i++) {
            rows[i] = new PriorityQueue<Cell>(N, comp);
            cols[i] = new PriorityQueue<Cell>(N, comp);
        }

        boolean[][] mark = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                mark[i][j] = false;
                rows[i].add(new Cell(a[i][j], i, j));
                cols[j].add(new Cell(a[i][j], i, j));
            }
        }

        int Q = sc.nextInt();

        for (int i = 0; i < Q; i++) {
            String type = sc.next();
            int pos = sc.nextInt();
            pos--;
            PriorityQueue<Cell> currentQ = null;
            if (type.equals("R")) { 
                currentQ = rows[pos];
            } else {
                currentQ = cols[pos];
            }
            Cell target = null;

            while (currentQ.size() > 0) {
                Cell peak = currentQ.poll();
                if (mark[peak.row][peak.col]) {
                    continue;
                } 
                mark[peak.row][peak.col] = true;
                target = peak;
                break;
            }
            if (target == null) {
                System.out.println("None");
            } else {
                System.out.println(target.value);
            }
        }
    }

    public static void main(String args[]) {
        Board runner = new Board();
        runner.run();
    }
}

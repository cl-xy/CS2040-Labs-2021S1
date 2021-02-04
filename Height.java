import java.util.*;

public class Height {
    private ArrayList<Edge>[] adjList;
    private boolean[] 
    private void run() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        adjList = new ArrayList<Edge>[N];
        visited = new boolean[N];
        for (int i = 0; i < V; i++) {
            adjList[i] = new ArrayList<Edge>();
        }

        for (int i = 0; i < N-1; i++) {
            int start = sc.nextInt() - 1;
            int end = sc.nextInt() - 1;
            int h = sc.nextInt();
            addEddge(start, end, h);
            addEddge(end, start, -h);
        }

        relHeight = new long[N];

    }

    private void dfs(int x) {
        if (visited[x]) return;

    public static void main(String args[]) {
        Height runner = new Height();
        runner.run();
    }
}

import java.util.*;

public class Football {
    private void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] list = new int[n];
        int k = n;
        int start = list[0];
        boolean ballBack = false;

        for (int i = 0; i < n; i++) {
            list[i] = sc.nextInt();
        }
        
        for (int j = 0; j < k; j++) {
            start = list[start];
            if (start == 0) {
                ballBack = true;
                break;
            }
        } 

        if (ballBack == true) {
            System.out.println("YES");
        }

        else {
            System.out.println("NO");
        }
        
    }

    public static void main(String args[]) {
        Football football = new Football();
        football.run();
    }
}

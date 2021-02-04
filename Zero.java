import java.util.*;

public class Zero {
    
    //to get the cumulative sum of subarrays
    public long[] cumArr(long[] arr, int n) {
        long[] s = new long[n];
        s[0] = arr[1];
        for (int i = 1; i < n; i++) {
            s[i] = s[i-1] + arr[i+1];
        }
        return s;
    }
    
    private void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n+1];
        long[] s;
        long count = 0;

        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextLong();
        }
        
        s = cumArr(arr, n);
        Arrays.sort(s);
        int index = 0;
        for (int i = 0; i < n; i++) {
           if (s[i] == 0) {
               count++;
           }
           //change index when value in cumSum array changes
           if (s[i] > s[index]){
               index = i;
               continue;
           } 
           
           if (s[i] == s[index] && i!=index) {
               count += (long) (i - index);
           }
        }

        System.out.println(count);
    }

    public static void main(String args[]) {
        Zero runner = new Zero();
        runner.run();
    }
}

import java.util.*;

public class Mexseq {
    private void run() {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int mex = sc.nextInt();
        int[] arr = new int[n];
        ArrayList<Integer> list;
        list = new ArrayList<Integer>();

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
    
        int k = mex;
        
        
        for (int i = 0; i < n; i++) {
            if ((arr[i] < mex) && (list.contains(arr[i]) == false)) {
                k--;
                list.add(arr[i]);
            }
            
            if (arr[i] == mex) {
                k++;
            }

            
        }
        
        
        System.out.println(k);

        
        
    }

    public static void main(String[] args) {
        Mexseq newMexseq = new Mexseq();
        newMexseq.run();
    }
}

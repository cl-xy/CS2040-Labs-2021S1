import java.util.*;

public class Palindrome {
    String input;
   
    public boolean recurse(int left, int right, int deletions_left) {
        if (left >= right) {
            return true;
        } else if (input.charAt(left) == input.charAt(right) && recurse(left + 1, right - 1, deletions_left)) {
            return true;
        } else if (deletions_left >= 1 && recurse(left + 1, right, deletions_left -1)) {
            return true;
        } else if (deletions_left >= 1 && recurse(left, right - 1, deletions_left - 1)) {
            return true;
        }
        return false;
    }

    private void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            input = sc.next();
            int k = sc.nextInt();
            int len = input.length();
            if (recurse(0, len-1, k)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static void main(String args[]) {
        Palindrome runner = new Palindrome();
        runner.run();
    }
}

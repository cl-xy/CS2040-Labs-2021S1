import java.util.*;

public class Bigcal {
    private void run() {

        Scanner sc = new Scanner(System.in);
        String firstNum = sc.next();
        String secondNum = sc.next();
        
        ArrayList<Integer> firstList = new ArrayList<>();
        ArrayList<Integer> secondList = new ArrayList<>();

        for (int i = firstNum.length() - 1; i>=0; i--) {
            firstList.add(firstNum.charAt(i) - '0');
        }

        for (int i = secondNum.length() - 1; i>=0; i--) {
            secondList.add(secondNum.charAt(i) - '0');
        }

        ArrayList<Integer> added = new ArrayList<>();

        while (firstList.size() > secondList.size()) secondList.add(0);

        while (secondList.size() > firstList.size()) firstList.add(0);

        int carry = 0;
        for (int i = 0; i < firstList.size(); i++) {
            int sum = firstList.get(i) + secondList.get(i) + carry;
            carry = sum / 10;
            sum = sum % 10;
            added.add(sum);
        }

        if (carry > 0) added.add(carry);

        for (int i = added.size() - 1; i >= 0; i--) {
            System.out.print(added.get(i));
        }

        System.out.println("");

    }

    public static void main(String[] args) {
        Bigcal newBigcal = new Bigcal();
        newBigcal.run();
    }
}

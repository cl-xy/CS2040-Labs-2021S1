import java.util.*;

public class Transpose {
	private void run() {
		Scanner sc = new Scanner(System.in);
        int numRow = sc.nextInt();
        int numCol = sc.nextInt();
        String[] arr = new String[numRow];
        String[] outArr = new String[numCol];

        for (int i = 0; i < numRow; i++){
            arr[i] = sc.next();
        }
        
        for (int j = 0; j < numCol; j++){
            String str = "";

            for (String m : arr){
                str+= m.charAt(j);
            }

            outArr[j] = str;
        }

        for (String n : outArr) {
            System.out.println(n);
        }

    }

	public static void main(String[] args) {
		Transpose newTranspose = new Transpose();
		newTranspose.run();
	}
}

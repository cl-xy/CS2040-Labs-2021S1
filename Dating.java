import java.util.*;

public class Dating {
    private void run() {

        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        ArrayList<String> list = new ArrayList<String>();
        Queue<String> queue = new LinkedList<>();
        
        //no. of matched pairs
        int matched = 0;
        int waitingTime = 0;

        for (int i = 0; i < T; i++) {
            String input = sc.nextLine();
            list.add(input);

            if (queue.size() == 0) {
                queue.add(input);
            }
              

            else {
                //checks gender of first in queue
                char genderA = (queue.peek()).charAt(0);

                //checks gender of new user
                char genderB = input.charAt(0);
               
                if (genderA != genderB){
                    
                    String nameA = queue.remove();
                    
                    //gets index of first user
                    int indexA = list.indexOf(nameA);
                    
                    //gets index of second user
                    int indexB = list.indexOf(input);
                    
                    waitingTime += indexB - indexA;
                    
                    list.set(indexA, "null");
                    list.set(indexB, "null");
                    matched++;

                    if (genderA == 'M') {
                        nameA = nameA.substring(5);
                        input = input.substring(6);
                        System.out.println(nameA + " matches" + input);
                    }

                    else {
                        input = input.substring(5);
                        nameA = nameA.substring(6);
                        System.out.println(input + " matches" + nameA);
                    }

                }

                else {
                    queue.add(input);
                }
            }
                    
        }
        
        float avgWT = (float) waitingTime/ ((float) (matched*2));
        System.out.printf("%.2f\n", avgWT); 
    }
    


    public static void main(String args[]) {
        Dating dating = new Dating();
        dating.run();
    }
}

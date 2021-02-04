import java.util.*;

public class Feeding {

    //reverse fullFishes by adding them to a new stack

    // precondition: n >=1, fullFishes stack cannot be empty
    // post-condition: a new stack of fullFishes in reversed order
    public static Stack<Long> reverse(Stack<Long> fullFishes, int n) {
        Stack<Long> stack = new Stack<Long>();

        //n is the number of inputs
        //pop input from fullFishes and subsequently add to new stack
        //until fullFishes become empty
        for (int i = 0; i < n; i++) {
            stack.add(fullFishes.pop());
        }

        return stack;
    }

    //whenever new hungryFish come in, feed it to stack
    //pre-condition: stack cannot be empty, hungryFish >=1
    //post-condition: hungryFish becomes full, the stack is updated.
    public static Stack<Long> feed(Stack<Long> stack, long hungryFish) {
        //newSize fish starts off with hungryFish's size
        long newSize = hungryFish;
        
        //if fullFish at top of stack is smaller in size than newSize fish
        // pop fullFish from stack, increase newSize fish by fullFish's length
        while (stack.peek() < newSize) {
            newSize += stack.pop();

            //if stack is empty after popping last fullFish
            //break out of while loop
            if (stack.empty()) {
                break;
            }
        }

        //newSize fish becomes full, pushed back into stack

        stack.push(newSize);
        return stack;
    }

    private void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        Stack<Long> fullFishes = new Stack<Long>();
        Stack<Long> pool = new Stack<Long>();

        //add inputs to fullFishes stack, smallest fish at bottom
        for (int i = 0; i < n; i++) {
            fullFishes.add(sc.nextLong());
        }
        
        //gives a stack, smallest fish on top
        pool = reverse(fullFishes, n);

        for (int i = 0; i < m; i++) {
            int hungryFish = sc.nextInt();
            pool = feed(pool, hungryFish);
        }

        //print out the stack
        while (pool.empty() == false) {
            System.out.print(pool.pop());
            if (pool.empty() == false) {
                System.out.print(" ");
            }
        }

        System.out.print("\n");

    }

    public static void main(String args[]) {
        Feeding feeding = new Feeding();
        feeding.run();
    }
}

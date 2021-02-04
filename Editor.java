import java.util.*;

public class Editor {
    private void run() {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int numOp = sc.nextInt();

        LinkedList<String> text = new LinkedList<>();       
        LinkedList<String> buffer = new LinkedList<>();
        ListIterator<String> buffer_itr = buffer.listIterator();
        
        for (int i = 0; i < s.length(); i++) {
            text.add(String.valueOf(s.charAt(i)));
        }

        ListIterator<String> text_itr = text.listIterator(0);

        
        for (int a = 0; a < numOp; a++) {
            String operation = sc.next();

            if (operation.equals("R")) {
                if (text_itr.hasNext()) {
                    text_itr.next();
                }
            }

            if (operation.equals("L")) {
                if (text_itr.hasPrevious()) {
                    text_itr.previous();
                }
            }

            if (operation.equals("C")) {
                int k = sc.nextInt();
                int index = text_itr.nextIndex();
                
                if (text.size() - index < k) {
                    for (int x = index; x < text.size(); x++) {
                        buffer_itr.add(text_itr.next());

                    } 
                   
                } else {
                    for (int j = 0; j < k; j++) {
                        buffer_itr.add(text_itr.next());
                    }  
                } 
                
                while (buffer_itr.hasPrevious()) {
                    buffer_itr.previous();
                    text_itr.previous();
                }
                
            }

            if (operation.equals("P")) {
                for (int i = 0; i < buffer.size(); i++) {
                    text_itr.add(buffer_itr.next());
                }
             
                while (buffer_itr.hasPrevious()){
                    buffer_itr.previous();
                    buffer_itr.remove();
                }
              
            }

            if (operation.equals("I")) {
                String c = sc.next();
                text_itr.add(c);
            }

            if (operation.equals("B")) {
                if (text_itr.hasPrevious()) {
                    text_itr.previous();
                    text_itr.remove();
                }
            }

        }

        for (String y : text) {
            System.out.print(y);
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        Editor newEditor = new Editor();
        newEditor.run();
    }
}

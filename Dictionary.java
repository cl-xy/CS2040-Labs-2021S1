import java.util.*;

public class Dictionary {
    public static class Node {
        public Node left;
        public Node right;
        public char value;
        public int size;

        Node() {
            this.value = '0';
            this.right = null;
            this.left = null;
            this.size = 0;
        }
        Node(char value) {
            this.value = value;
            this.right = null;
            this.left = null;
            this.size = 0;
        }
    }

    public static class BinarySearchTree {
        public Node root;
        public Node current;
        public BinarySearchTree() {
            root = new Node();
        }

        public void insert(String input) {
            current = root;
            for (int i = 0; i < input.length(); i++) {
                Node newNode = new Node(input.charAt(i));
                if (newNode.value == 'a' && current.left == null) {
                    current.left = newNode;
                    current = current.left;
                    current.size++;
                } else if (newNode.value == 'b' && current.right == null) {
                    current.right = newNode;
                    current = current.right;
                    current.size++;
                } else if (newNode.value == 'a') {
                    current = current.left;
                    current.size++;
                } else {
                    current = current.right;
                    current.size++;
                }
            }
        }
        

        public int subtreeSize(String input) {
            current = root;
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == 'a' && current.left != null) {
                    current = current.left;
                } else if (input.charAt(i) == 'b' && current.right != null){
                    current = current.right;
                } else {
                    return 0;
                }
            }
            return current.size;
        }
    }
            
    private void run() {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int q = sc.nextInt();

        BinarySearchTree bst = new BinarySearchTree();

        for (int i = 0; i < n; i++) {
            String input = sc.next();
            bst.insert(input);
        }

        for (int i = 0; i < q; i++) {
            System.out.println(bst.subtreeSize(sc.next()));
        }
    }

    public static void main(String args[]) {
        Dictionary runner = new Dictionary();
        runner.run();
    }
}

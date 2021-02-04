import java.util.*;

public class Lca {
    public static class Node {
        public Node left;
        public Node right;
        public int value;
        public int label;
    }

    private void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();

        Node[] nodes = new Node[n + 1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node();
            nodes[i].value = sc.nextInt();
            nodes[i].label = i;
        }

        for (int i = 1; i < n; i++) {
            String type = sc.next();
            int p = sc.nextInt();
            int u = sc.nextInt();
            if (type.equals("L")) {
                nodes[p].left = nodes[u];
            } else {
                nodes[p].right = nodes[u];
            }
        }

        while (q-- > 0) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            if (nodes[u].value > nodes[v].value) {
                int temp = u;
                u = v;
                v = temp;
            }

            Node current = nodes[1];
            while (true) {
                if (current.value > nodes[u].value && current.value < nodes[v].value) {
                    break;
                }
                if (current.value == nodes[u].value || current.value == nodes[v].value) {
                    break;
                }
                if (current.value > nodes[v].value) {
                    current = current.left;
                } else {
                    current = current.right;
                }
            }
            System.out.println(current.label);
        }

    }

    public static void main(String args[]) {
        Lca runner = new Lca();
        runner.run();
    }
}

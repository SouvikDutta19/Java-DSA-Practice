import java.util.*;

class Node {
    int data;
    Node left, right;
    Node(int item) { data = item; left = right = null; }
}

public class day99_binarytreezigzag {
    static List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        boolean leftToRight = true;

        while (!q.isEmpty()) {
            int size = q.size();
            LinkedList<Integer> row = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                Node node = q.poll();
                if (leftToRight) row.addLast(node.data);
                else row.addFirst(node.data);
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            res.add(row);
            leftToRight = !leftToRight;
        }
        return res;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.right = new Node(5);

        System.out.println(zigzagLevelOrder(root));
    }
}

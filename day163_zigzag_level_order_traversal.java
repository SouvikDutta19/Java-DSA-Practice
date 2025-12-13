import java.util.*;

class NodeZ {
    int data;
    NodeZ left, right;

    NodeZ(int data) {
        this.data = data;
    }
}

public class day163_zigzag_level_order_traversal {

    public static void zigzag(NodeZ root) {
        if (root == null) return;

        Queue<NodeZ> queue = new LinkedList<>();
        boolean leftToRight = true;

        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int[] level = new int[size];

            for (int i = 0; i < size; i++) {
                NodeZ curr = queue.poll();
                int index = leftToRight ? i : size - 1 - i;
                level[index] = curr.data;

                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }

            for (int val : level)
                System.out.print(val + " ");

            leftToRight = !leftToRight;
        }
    }

    public static void main(String[] args) {
        NodeZ root = new NodeZ(1);
        root.left = new NodeZ(2);
        root.right = new NodeZ(3);
        root.left.left = new NodeZ(4);
        root.left.right = new NodeZ(5);
        root.right.left = new NodeZ(6);
        root.right.right = new NodeZ(7);

        zigzag(root);
    }
}
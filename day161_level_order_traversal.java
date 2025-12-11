import java.util.*;

class NodeLO {
    int data;
    NodeLO left, right;

    NodeLO(int data) {
        this.data = data;
    }
}

public class day161_level_order_traversal {

    public static void levelOrder(NodeLO root) {
        if (root == null) return;

        Queue<NodeLO> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            NodeLO temp = q.poll();
            System.out.print(temp.data + " ");

            if (temp.left != null)
                q.add(temp.left);

            if (temp.right != null)
                q.add(temp.right);
        }
    }

    public static void main(String[] args) {
        NodeLO root = new NodeLO(1);
        root.left = new NodeLO(2);
        root.right = new NodeLO(3);
        root.left.left = new NodeLO(4);
        root.left.right = new NodeLO(5);

        System.out.println("Level Order Traversal:");
        levelOrder(root);
    }
}
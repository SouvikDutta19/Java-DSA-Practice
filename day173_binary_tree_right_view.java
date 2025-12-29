import java.util.*;

public class day173_binary_tree_right_view {

    static class Node {
        int val; Node left, right;
        Node(int v){ val = v; }
    }

    public static List<Integer> rightView(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++){
                Node node = q.poll();
                if(i == size - 1) res.add(node.val);
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(5);
        root.right.right = new Node(4);
        System.out.println("Right View: " + rightView(root));
    }
}
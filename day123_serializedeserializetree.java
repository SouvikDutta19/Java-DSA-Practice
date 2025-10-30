// day123_serializedeserializetree.java
import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int v) { val = v; }
}

public class day123_serializedeserializetree {
    public String serialize(TreeNode root) {
        if (root == null) return "null,";
        return root.val + "," + serialize(root.left) + serialize(root.right);
    }

    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        return helper(q);
    }

    TreeNode helper(Queue<String> q) {
        String val = q.poll();
        if (val.equals("null")) return null;
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = helper(q);
        node.right = helper(q);
        return node;
    }

    public static void main(String[] args) {
        day123_serializedeserializetree obj = new day123_serializedeserializetree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        String ser = obj.serialize(root);
        System.out.println("Serialized: " + ser);
        TreeNode deser = obj.deserialize(ser);
        System.out.println("Deserialized Root Value: " + deser.val);
    }
}

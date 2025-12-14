import java.util.*;

class TreeNode164 {
    int val;
    TreeNode164 left, right;

    TreeNode164(int val) {
        this.val = val;
    }
}

public class day164_serialize_deserialize_binary_tree {

    static String serialize(TreeNode164 root) {
        if (root == null) return "#";

        return root.val + "," +
               serialize(root.left) + "," +
               serialize(root.right);
    }

    static TreeNode164 deserialize(Queue<String> q) {
        String val = q.poll();
        if (val.equals("#")) return null;

        TreeNode164 node = new TreeNode164(Integer.parseInt(val));
        node.left = deserialize(q);
        node.right = deserialize(q);
        return node;
    }

    public static void main(String[] args) {
        TreeNode164 root = new TreeNode164(1);
        root.left = new TreeNode164(2);
        root.right = new TreeNode164(3);

        String data = serialize(root);
        System.out.println("Serialized: " + data);

        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        TreeNode164 newRoot = deserialize(q);
        System.out.println("Deserialized Root: " + newRoot.val);
    }
}
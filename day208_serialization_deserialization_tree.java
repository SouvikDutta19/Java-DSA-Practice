import java.util.*;

public class day208_serialization_deserialization_tree {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val){ this.val = val; }
    }

    public static String serialize(TreeNode root){

        if(root == null) return "null";

        return root.val + "," +
               serialize(root.left) + "," +
               serialize(root.right);
    }

    public static TreeNode deserialize(String data){

        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        return build(q);
    }

    static TreeNode build(Queue<String> q){

        String val = q.poll();

        if(val.equals("null")) return null;

        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = build(q);
        node.right = build(q);

        return node;
    }
}
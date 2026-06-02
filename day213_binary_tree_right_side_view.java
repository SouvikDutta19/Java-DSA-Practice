import java.util.*;

public class day213_binary_tree_right_side_view {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val){
            this.val = val;
        }
    }

    public static List<Integer> rightSideView(TreeNode root){

        List<Integer> result = new ArrayList<>();

        if(root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){

            int size = queue.size();

            for(int i=0;i<size;i++){

                TreeNode node = queue.poll();

                if(i == size - 1)
                    result.add(node.val);

                if(node.left != null)
                    queue.offer(node.left);

                if(node.right != null)
                    queue.offer(node.right);
            }
        }

        return result;
    }
}
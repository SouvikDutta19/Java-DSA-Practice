import java.util.*;

public class day211_kth_smallest_in_bst {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v){ val = v; }
    }

    public static int kthSmallest(TreeNode root, int k){

        Stack<TreeNode> st = new Stack<>();

        while(true){

            while(root != null){
                st.push(root);
                root = root.left;
            }

            root = st.pop();
            if(--k == 0) return root.val;

            root = root.right;
        }
    }
}
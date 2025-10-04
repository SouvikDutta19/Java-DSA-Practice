class Node {
    int val;
    Node left,right;
    Node(int val){this.val=val;}
}

public class day98_binary_tree_diameter {
    static int diameter=0;
    static int height(Node root){
        if(root==null) return 0;
        int l=height(root.left);
        int r=height(root.right);
        diameter=Math.max(diameter,l+r);
        return 1+Math.max(l,r);
    }
    public static int diameterOfBinaryTree(Node root){
        height(root);
        return diameter;
    }
    public static void main(String[] args){
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        System.out.println("Diameter: "+diameterOfBinaryTree(root));
    }
}
